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

import com.moubieapi.api.inventory.InventoryRegister;
import com.moubieapi.api.inventory.gui.GUI;
import com.moubieapi.moubieapi.reflect.ReflectAbstract;
import org.bukkit.event.inventory.InventoryEvent;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 代表使用者介面處理程序
 * @author MouBieCat
 */
public final class UInventoryHandler {

    // 處理介面
    @NotNull
    private final GUI handler;

    // 運行動作集合
    @NotNull
    private final List<Method> methods = new LinkedList<>();

    /**
     * 建構子
     * @param gui 處理介面
     * @param type 處理事件類型
     */
    public UInventoryHandler(final @NotNull GUI gui, final @NotNull InventoryRegister.EventType type) {
        this.handler = gui;
        this.shortEvent(type);
    }

    /**
     * 排序一個插件註冊動作的所有方法(優先等級)
     * @param type 運行事件類型
     */
    private void shortEvent(final @NotNull InventoryRegister.EventType type) {
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
            this.methods.addAll(sortedMethods);
        }
    }

    /**
     * 運行事件方法
     * @param event 事件實例
     */
    public void executeEvent(final @NotNull InventoryEvent event) {
        if (this.methods.size() > 0)
            for (final Method method : this.methods)
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
