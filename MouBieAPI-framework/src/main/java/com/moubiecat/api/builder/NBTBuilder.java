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

package com.moubiecat.api.builder;

import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個 NBTTag 建構介面
 * @param <T> 具有NBTTag的對象類
 * @author MouBieCat
 */
public interface NBTBuilder<T>
        extends Builder<T> {

    /**
     * 獲取當前的主路徑名稱
     * @return 名稱
     */
    @NotNull String getMainTagName();

    /**
     * 獲取NBTag物件
     * @return NBTag
     */
    @NotNull CompoundTag getCompound();

    /**
     * 在該 tag 上設置一個 boolean
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTBuilder<T> setBoolean(@NotNull String var1, boolean var2);

    /**
     * 在該 tag 上設置一個 byte
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTBuilder<T> setByte(@NotNull String var1, byte var2);

    /**
     * 在該 tag 上設置一個 double
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTBuilder<T> setDouble(@NotNull String var1, double var2);

    /**
     * 在該 tag 上設置一個 float
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTBuilder<T> setFloat(@NotNull String var1, float var2);

    /**
     * 在該 tag 上設置一個 int
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTBuilder<T> setInt(@NotNull String var1, int var2);

    /**
     * 在該 tag 上設置一個 long
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTBuilder<T> setLong(@NotNull String var1, long var2);

    /**
     * 在該 tag 上設置一個 short
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTBuilder<T> setShort(@NotNull String var1, short var2);

    /**
     * 在該 tag 上設置一個 String
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull NBTBuilder<T> setString(@NotNull String var1, @NotNull String var2);

    /**
     * 在該 tag 上或取一個 boolean
     * @param var1 路徑
     * @return 資料
     */
    boolean getBoolean(@NotNull String var1);

    /**
     * 在該 tag 上或取一個 byte
     * @param var1 路徑
     * @return 資料
     */
    byte getByte(@NotNull String var1);

    /**
     * 在該 tag 上或取一個 double
     * @param var1 路徑
     * @return 資料
     */
    double getDouble(@NotNull String var1);

    /**
     * 在該 tag 上或取一個 float
     * @param var1 路徑
     * @return 資料
     */
    float getFloat(@NotNull String var1);

    /**
     * 在該 tag 上或取一個 int
     * @param var1 路徑
     * @return 資料
     */
    int getInt(@NotNull String var1);

    /**
     * 在該 tag 上或取一個 long
     * @param var1 路徑
     * @return 資料
     */
    long getLong(@NotNull String var1);

    /**
     * 在該 tag 上或取一個 short
     * @param var1 路徑
     * @return 資料
     */
    short getShort(@NotNull String var1);

    /**
     * 在該 tag 上或取一個 String
     * @param var1 路徑
     * @return 資料
     */
    @NotNull String getString(@NotNull String var1);

    /**
     * 檢查是否包含一個路徑
     * @param var1 路徑
     * @return 資料
     */
    boolean hasTag(@NotNull String var1);

}
