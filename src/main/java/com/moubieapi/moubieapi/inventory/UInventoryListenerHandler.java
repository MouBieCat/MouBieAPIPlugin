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

package com.moubieapi.moubieapi.inventory;

import com.moubieapi.api.inventory.GUIHandler;
import com.moubieapi.api.inventory.InventoryRegister;
import com.moubieapi.api.inventory.gui.GUI;
import com.moubieapi.moubieapi.reflect.ReflectAbstract;
import org.bukkit.event.inventory.InventoryEvent;
import org.jetbrains.annotations.NotNull;

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
    private final Map<InventoryRegister.EventType, List<Method>> eventMethods = new LinkedHashMap<>();

    /**
     * 建構子
     * @param gui 處理介面
     */
    public UInventoryListenerHandler(final @NotNull GUI gui) {
        this.handler = gui;

        // 初始化
        this.shortListener(InventoryRegister.EventType.OPEN_INVENTORY);
        this.shortListener(InventoryRegister.EventType.CLICK_INVENTORY);
        this.shortListener(InventoryRegister.EventType.CLOSE_INVENTORY);
    }

    /**
     * 排序一個插件註冊動作的所有方法(優先等級)
     * @param type 運行事件類型
     */
    private void shortListener(final @NotNull InventoryRegister.EventType type) {
        final List<Method> methods = new LinkedList<>();

        // 查找有關 Register.class 的類方法並且判斷方法示標動作類型
        for (final Method method : this.handler.getClass().getDeclaredMethods())
            if (method.isAnnotationPresent(InventoryRegister.class) && method.getAnnotation(InventoryRegister.class).type().equals(type))
                methods.add(method);

        if (methods.size() > 0) {
            // 根據 Register 做優先等級排序
            final List<Method> sortedMethods = methods.stream().sorted(
                    Comparator.comparing(a -> a.getAnnotation(InventoryRegister.class).priority())
            ).toList();

            // 添加
            this.eventMethods.put(type, sortedMethods);
        }
    }

    /**
     * 運行事件方法
     * @param event 事件實例
     */
    public void executeListener(final @NotNull InventoryEvent event, final @NotNull InventoryRegister.EventType type) {
        final List<Method> methods = this.eventMethods.get(type);

        if (methods != null)
            for (final Method method : methods)
                ReflectAbstract.invoke(method, this.handler, event);
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