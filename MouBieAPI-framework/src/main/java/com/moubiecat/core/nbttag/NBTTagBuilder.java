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

package com.moubiecat.core.nbttag;

import com.moubiecat.api.builder.NBTBuilder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個 NBTTag 建構介面
 * @param <T> 具有NBTTag的對象類
 * @author MouBieCat
 */
public abstract class NBTTagBuilder<T>
        implements NBTBuilder<T> {

    // 主路徑名稱
    @NotNull
    protected final String mainTagName;

    // NBT TAG 實例
    @NotNull
    protected final CompoundTag compound = new CompoundTag();

    // NBTTag 要建構的對象
    @NotNull
    protected final T builder;

    /**
     * 建構子
     * @param builder 建構的對象
     * @param mainTagName 標籤主路徑
     */
    public NBTTagBuilder(final @NotNull T builder, final @NotNull String mainTagName) {
        this.builder = builder;
        this.mainTagName = mainTagName;
    }

    /**
     * 獲取當前的主路徑名稱
     * @return 名稱
     */
    @NotNull
    public final String getMainTagName() {
        return this.mainTagName;
    }

    /**
     * 獲取NBTag物件
     * @return NBTag
     */
    @NotNull
    public final Tag getCompound() {
        return this.compound;
    }

    /**
     * 獲取當前 NBTTag 要建構的對象
     * @return 建構對象
     */
    @NotNull
    public final T getBuilder() {
        return this.builder;
    }

    /**
     * 在該 tag 上設置一個 boolean
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public final NBTBuilder<T> setBoolean(final @NotNull String var1, final boolean var2) {
        this.compound.putBoolean(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上設置一個 byte
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public final NBTBuilder<T> setByte(final @NotNull String var1, final byte var2) {
        this.compound.putByte(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上設置一個 double
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public final NBTBuilder<T> setDouble(final @NotNull String var1, final double var2) {
        this.compound.putDouble(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上設置一個 float
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public final NBTBuilder<T> setFloat(final @NotNull String var1, final float var2) {
        this.compound.putFloat(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上設置一個 int
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public final NBTBuilder<T> setInt(final @NotNull String var1, final int var2) {
        this.compound.putInt(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上設置一個 long
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public final NBTBuilder<T> setLong(final @NotNull String var1, final long var2) {
        this.compound.putLong(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上設置一個 short
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public final NBTBuilder<T> setShort(final @NotNull String var1, final short var2) {
        this.compound.putShort(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上設置一個 String
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public final NBTBuilder<T> setString(final @NotNull String var1, final @NotNull String var2) {
        this.compound.putString(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上或取一個 boolean
     * @param var1 路徑
     * @return 資料
     */
    public final boolean getBoolean(final @NotNull String var1) {
        return this.compound.getBoolean(var1);
    }

    /**
     * 在該 tag 上或取一個 byte
     * @param var1 路徑
     * @return 資料
     */
    public final byte getByte(final @NotNull String var1) {
        return this.compound.getByte(var1);
    }

    /**
     * 在該 tag 上或取一個 double
     * @param var1 路徑
     * @return 資料
     */
    public final double getDouble(final @NotNull String var1) {
        return this.compound.getDouble(var1);
    }

    /**
     * 在該 tag 上或取一個 float
     * @param var1 路徑
     * @return 資料
     */
    public final float getFloat(final @NotNull String var1) {
        return this.compound.getFloat(var1);
    }

    /**
     * 在該 tag 上或取一個 int
     * @param var1 路徑
     * @return 資料
     */
    public final int getInt(final @NotNull String var1) {
        return this.compound.getInt(var1);
    }

    /**
     * 在該 tag 上或取一個 long
     * @param var1 路徑
     * @return 資料
     */
    public final long getLong(final @NotNull String var1) {
        return this.compound.getLong(var1);
    }

    /**
     * 在該 tag 上或取一個 short
     * @param var1 路徑
     * @return 資料
     */
    public final short getShort(final @NotNull String var1) {
        return this.compound.getShort(var1);
    }

    /**
     * 在該 tag 上或取一個 String
     * @param var1 路徑
     * @return 資料
     */
    @NotNull
    public final String getString(final @NotNull String var1) {
        return this.compound.getString(var1);
    }

    /**
     * 檢查是否包含一個路徑
     * @param var1 路徑
     * @return 資料
     */
    public final boolean hasTag(final @NotNull String var1) {
        return this.compound.contains(var1);
    }

}
