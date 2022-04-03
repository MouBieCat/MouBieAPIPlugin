/**
 * LICENSE
 * MouBieAPI
 * -------------
 * Copyright (C) 2021 MouBieCat(MouBie_Yuki)
 * -------------
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 */

package com.moubiecat.core.inventory;

import com.moubiecat.api.inventory.button.Button;
import com.moubiecat.api.inventory.button.Clickable;
import com.moubiecat.api.inventory.button.event.ClickButtonEvent;
import com.moubiecat.api.inventory.gui.GUI;
import com.moubiecat.api.inventory.gui.GUIHandler;
import com.moubiecat.api.inventory.gui.GUIRegister;
import com.moubiecat.core.reflect.CraftBukkitReflect;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Method;
import java.util.*;

/**
 * 代表使用者介面處理程序
 * @author MouBieCat
 */
public final class UInventoryListenerHandler
        implements GUIHandler {

    // 處理介面
    @NotNull
    private final GUI handler;

    // 運行操作管理器
    @NotNull
    private final Map<Class<? extends InventoryEvent>, List<Method>> eventMethods = new LinkedHashMap<>();

    // 點擊按鈕集合
    @NotNull
    private final Map<UUID, Button> buttons = new LinkedHashMap<>();

    /**
     * 建構子
     * @param gui 處理介面
     */
    public UInventoryListenerHandler(final @NotNull GUI gui) {
        this.handler = gui;

        // 初始化
        this.shortListener(InventoryOpenEvent.class);
        this.shortListener(InventoryClickEvent.class);
        this.shortListener(InventoryCloseEvent.class);
    }

    /**
     * 運行事件方法
     * @param event 事件實例
     */
    public void executeListener(final @NotNull InventoryEvent event) {
        // 處理按鈕事件
        if (event instanceof InventoryClickEvent clickEvent)
            if (this.executeInventoryClickEvent0(clickEvent))
                return;

        // 處理類函數事件
        final List<Method> methods = this.eventMethods.get(event.getClass());
        if (methods != null) {
            for (final Method method : methods)
                CraftBukkitReflect.invoke(method, this.handler, event);
        }
    }

    /**
     * 處理按鈕事件
     * @param event 事件
     * @return 是否已經運行過按鈕
     */
    private boolean executeInventoryClickEvent0(final @NotNull InventoryClickEvent event) {
        // 獲取點擊按鈕ID
        final @Nullable UUID buttonId = ButtonBuilder.getButtonId(event.getCurrentItem());
        if (buttonId == null)
            return false;

        // 獲取按鈕
        final @Nullable Button button = this.buttons.get(buttonId);
        if (button == null)
            return false;

        if (button instanceof Clickable clickable) {
            clickable.executeButtonClick(
                    new ClickButtonEvent(this.handler, event.getClick(), (Player) event.getWhoClicked(), event.getSlot())
            );

            // 重新繪製按鈕
            this.handler.drawButton(button);
        }

        // 該按鈕是否取消事件
        event.setCancelled(button.isButtonCancelEvent());
        return true;
    }

    /**
     * 排序一個插件註冊動作的所有方法(優先等級)
     * @param eventClass 事件類
     */
    private void shortListener(final @NotNull Class<? extends InventoryEvent> eventClass) {
        final List<Method> methods = new LinkedList<>();

        for (final Method method : this.handler.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(GUIRegister.class) && method.getParameterCount() == 1) {
                final Class<?> parameter = method.getParameterTypes()[0];

                if (parameter.equals(eventClass))
                    methods.add(method);
            }
        }

        if (methods.size() > 0) {
            // 根據 Register 做優先等級排序
            final List<Method> sortedMethods = methods.stream().sorted(
                    Comparator.comparing(a -> a.getAnnotation(GUIRegister.class).priority())
            ).toList();

            this.eventMethods.put(eventClass, sortedMethods);
        }
    }

    /**
     * 註冊點擊按鈕
     * @param buttons 按鈕
     */
    public void registerButton(final @NotNull Button... buttons) {
        for (final Button button : buttons)
            this.buttons.put(button.getButtonId(), button);
    }

    /**
     * 獲取正在處理介面
     * @return 介面
     */
    @NotNull
    public GUI getHandler() {
        return this.handler;
    }

}
