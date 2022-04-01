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

import com.moubiecat.api.inventory.button.ClickButton;
import com.moubiecat.api.inventory.gui.GUI;
import com.moubiecat.api.inventory.gui.GUIHandler;
import com.moubiecat.api.inventory.gui.GUIRegister;
import com.moubiecat.core.reflect.CraftBukkitReflect;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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
    private final Map<String, List<Method>> eventMethods = new LinkedHashMap<>();

    // 點擊按鈕集合
    @NotNull
    private final Map<ItemStack, ClickButton> clickButtonMap = new HashMap<>();

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
     * 排序一個插件註冊動作的所有方法(優先等級)
     * @param eventClass 事件類
     */
    private void shortListener(final @NotNull Class<? extends InventoryEvent> eventClass) {
        final List<Method> methods = new LinkedList<>();

        for (final Method method : this.handler.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(GUIRegister.class) && method.getParameterCount() == 1) {
                final Parameter parameter = method.getParameters()[0];

                if (parameter.getType().equals(eventClass))
                    methods.add(method);
            }
        }

        if (methods.size() > 1) {
            // 根據 Register 做優先等級排序
            final List<Method> sortedMethods = methods.stream().sorted(
                    Comparator.comparing(a -> a.getAnnotation(GUIRegister.class).priority())
            ).toList();

            this.eventMethods.put(eventClass.getName(), sortedMethods);
        }
    }

    /**
     * 運行按鈕事件
     * @param event 事件
     */
    private void executeClickButton(final @NotNull InventoryClickEvent event) {
        final @Nullable ClickButton button = this.clickButtonMap.get(event.getCurrentItem());
        if (button != null)
            button.onClick(this.handler, (Player) event.getWhoClicked());
    }

    /**
     * 運行事件方法
     * @param event 事件實例
     */
    public void executeListener(final @NotNull InventoryEvent event) {
        // 處理按鈕事件
        if (event instanceof InventoryClickEvent clickEvent)
            this.executeClickButton(clickEvent);

        // 處理類函數事件
        final List<Method> methods = this.eventMethods.get(event.getClass().getName());

        if (methods != null) {
            for (final Method method : methods)
                CraftBukkitReflect.invoke(method, this.handler, event);

            // 是否為可取消對象 (根據GUI對象來判斷是否無論如何取消事件調用)
            if (event instanceof Cancellable cancellable)
                cancellable.setCancelled(this.handler.isCancelEvent());
        }
    }

    /**
     * 註冊點擊按鈕
     * @param buttons 按鈕
     */
    public void registerClickButton(final @NotNull ClickButton... buttons) {
        for (final ClickButton button : buttons)
            this.clickButtonMap.put(button.build(), button);
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
