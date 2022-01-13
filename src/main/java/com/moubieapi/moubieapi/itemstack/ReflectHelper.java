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

package com.moubieapi.moubieapi.itemstack;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 代表 NMS 有關的幫助類
 * @author MouBieCat
 */
public abstract class ReflectHelper {

    // 獲取當前版本(用於將類用路徑做反射)
    @NotNull
    protected static final String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

    /**
     * 根據路徑獲取一個 Class 類
     * @param path 路徑
     * @return 類
     */
    @NotNull
    @SuppressWarnings("all")
    protected static Class<?> getClass(final @NotNull String path) {
        try {
            return Class.forName(path);
        } catch (final ClassNotFoundException ignored) {}
        return null;
    }

    /**
     * 根據一個 Class 類獲取類的一個方法
     * @param clazz 類
     * @param methodName 方法名稱
     * @param argsClass 方法參數對照表
     * @return 類方法
     */
    @NotNull
    @SuppressWarnings("all")
    protected static Method getMethod(final @NotNull Class<?> clazz, final @NotNull String methodName, final @NotNull Class<?>... argsClass) {
        try {
            return clazz.getMethod(methodName, argsClass);
        } catch (final NoSuchMethodException ignored) {}
        return null;
    }

    /**
     * 調用一個類方法
     * @param method 類方法
     * @param obj 在哪個實例上調用
     * @param args 類方法參數
     * @return
     */
    @NotNull
    @SuppressWarnings("all")
    protected static Object invoke(final @NotNull Method method, final @Nullable Object obj, final @Nullable Object... args) {
        try {
            return method.invoke(obj, args);
        } catch (final InvocationTargetException | IllegalAccessException ignored) {}
        return null;
    }

}
