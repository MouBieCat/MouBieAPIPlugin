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

package com.moubiecat.core.reflect;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 提供一些基本的反射機制代碼
 * @author MouBieCat
 */
abstract class ReflectAbstract {

    /**
     * 根據路徑獲取一個 Class 類
     * @param path 路徑
     * @return 類
     */
    @NotNull
    @SuppressWarnings("all")
    public static Class<?> getClass(final @NotNull String path) {
        try {
            return Class.forName(path);
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根據一個 Class 類獲取類的一個屬性
     * @param clazz 類
     * @param fieldName 屬性名稱
     * @return 類屬性
     */
    @NotNull
    @SuppressWarnings("all")
    public static Field getField(final @NotNull Class<?> clazz, final @NotNull String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (final NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根據一個屬性獲取一個對想屬性實例
     * @param field 屬性
     * @param object 獲取對象
     * @return 對象屬性實例
     */
    @NotNull
    @SuppressWarnings("all")
    public static Object getObject(final @NotNull Field field, final @NotNull Object object) {
        try {
            field.setAccessible(true);
            return field.get(object);
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        }
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
    public static Method getMethod(final @NotNull Class<?> clazz, final @NotNull String methodName, final @NotNull Class<?>... argsClass) {
        try {
            return clazz.getMethod(methodName, argsClass);
        } catch (final NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 調用一個類方法
     * @param method 類方法
     * @param privateCall 是否強制繞過調用訪問
     * @param obj 在哪個實例上調用
     * @param args 類方法參數
     * @return
     */
    @NotNull
    @SuppressWarnings("all")
    public static Object invoke(final @NotNull Method method, final @Nullable Object obj, final @Nullable Object... args) {
        try {
            method.setAccessible(true);
            return method.invoke(obj, args);
        } catch (final InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
