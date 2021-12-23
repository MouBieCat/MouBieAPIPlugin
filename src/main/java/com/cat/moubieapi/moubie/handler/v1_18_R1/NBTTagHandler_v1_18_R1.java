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

package com.cat.moubieapi.moubie.handler.v1_18_R1;

import com.cat.moubieapi.api.handler.NBTHandler;
import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.craftbukkit.v1_18_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 該操作類只適用於 Minecraft 架構 (v1_18_R1)
 * @author MouBieCat
 */
public final class NBTTagHandler_v1_18_R1
        implements NBTHandler {

    // 主路徑名稱
    private String mainTagName = "default_tag_name";

    // NBT TAG 實例
    private NBTTagCompound compound = new NBTTagCompound();

    /**
     * 獲取當前使用的 nms 版本
     * @return 版本
     */
    @NotNull
    public String getVersion() {
        return "v1_18_R1";
    }

    /**
     * 獲取當前的主路徑名稱
     * @return 名稱
     */
    @NotNull
    public String getMainTagName() {
        return this.mainTagName;
    }

    /**
     * 設置當前的主路徑名稱
     * @param tagName 新名稱
     * @return 當前的建構器
     */
    @NotNull
    public NBTHandler setMainTagName(final @NotNull String tagName) {
        this.mainTagName = tagName;
        return this;
    }

    /**
     * 重製所有配置 (tag、mainTagName)
     */
    @Override
    public void remake() {
        this.mainTagName = "default_tag_name";
        this.compound = new NBTTagCompound();
    }

    /**
     * 在該 tag 上設置一個 boolean
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public NBTHandler setBoolean(final @NotNull String var1, final boolean var2) {
        this.compound.a(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上設置一個 byte
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public NBTHandler setByte(final @NotNull String var1, final byte var2) {
        this.compound.a(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上設置一個 double
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public NBTHandler setDouble(final @NotNull String var1, final double var2) {
        this.compound.a(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上設置一個 float
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public NBTHandler setFloat(final @NotNull String var1, final float var2) {
        this.compound.a(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上設置一個 int
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public NBTHandler setInt(final @NotNull String var1, final int var2) {
        this.compound.a(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上設置一個 long
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public NBTHandler setLong(final @NotNull String var1, final long var2) {
        this.compound.a(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上設置一個 short
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public NBTHandler setShort(final @NotNull String var1, final short var2) {
        this.compound.a(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上設置一個 String
     * @param var1 路徑
     * @param var2 資料
     * @return 當前的建構器
     */
    @NotNull
    public NBTHandler setString(final @NotNull String var1, final @NotNull String var2) {
        this.compound.a(var1, var2);
        return this;
    }

    /**
     * 在該 tag 上或取一個 boolean
     * @param var1 路徑
     * @return 資料
     */
    public boolean getBoolean(final @NotNull String var1) {
        return this.compound.b(var1);
    }

    /**
     * 在該 tag 上或取一個 byte
     * @param var1 路徑
     * @return 資料
     */
    public byte getByte(final @NotNull String var1) {
        return this.compound.d(var1);
    }

    /**
     * 在該 tag 上或取一個 double
     * @param var1 路徑
     * @return 資料
     */
    public double getDouble(final @NotNull String var1) {
        return this.compound.k(var1);
    }

    /**
     * 在該 tag 上或取一個 float
     * @param var1 路徑
     * @return 資料
     */
    public float getFloat(final @NotNull String var1) {
        return this.compound.j(var1);
    }

    /**
     * 在該 tag 上或取一個 int
     * @param var1 路徑
     * @return 資料
     */
    public int getInt(final @NotNull String var1) {
        return this.compound.h(var1);
    }

    /**
     * 在該 tag 上或取一個 long
     * @param var1 路徑
     * @return 資料
     */
    public long getLong(final @NotNull String var1) {
        return this.compound.i(var1);
    }

    /**
     * 在該 tag 上或取一個 short
     * @param var1 路徑
     * @return 資料
     */
    public short getShort(final @NotNull String var1) {
        return this.compound.g(var1);
    }

    /**
     * 在該 tag 上或取一個 String
     * @param var1 路徑
     * @return 資料
     */
    @NotNull
    public String getString(final @NotNull String var1) {
        return this.compound.l(var1);
    }

    /**
     * 檢查是否包含一個路徑
     * @param var1 路徑
     * @return 資料
     */
    public boolean hasTag(final @NotNull String var1) {
        return this.compound.e(var1);
    }

    /**
     * 將一個物品寫入該 tag
     * @param var1 寫入的物品
     * @return 寫入後的物品
     */
    @NotNull
    public ItemStack build(final @NotNull ItemStack var1) {
        final net.minecraft.world.item.ItemStack itemStack = CraftItemStack.asNMSCopy(var1);
        final NBTTagCompound tag = itemStack.e() ? itemStack.s() : new NBTTagCompound();

        if (tag != null) {
            // 將當前的配置寫入物品Tag
            tag.a(this.mainTagName, this.compound);
            itemStack.c(tag);
        }

        // 清除當前的配置
        this.remake();
        return CraftItemStack.asBukkitCopy(itemStack);
    }

    /**
     * 在一個物品上解析 tag 類型 boolean
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    public boolean getBoolean(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final net.minecraft.world.item.ItemStack itemStack = CraftItemStack.asNMSCopy(var1);
        final NBTTagCompound tag = itemStack.e() ? itemStack.s() : new NBTTagCompound();

        if (tag != null && tag.e(var2)) {
            final NBTTagCompound compound = tag.p(var2);
            return compound.e(var3) && compound.b(var3);
        }
        return false;
    }

    /**
     * 在一個物品上解析 tag 類型 byte
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    public byte getByte(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final net.minecraft.world.item.ItemStack itemStack = CraftItemStack.asNMSCopy(var1);
        final NBTTagCompound tag = itemStack.e() ? itemStack.s() : new NBTTagCompound();

        if (tag != null && tag.e(var2)) {
            final NBTTagCompound compound = tag.p(var2);
            return compound.e(var3) ? compound.d(var3) : 0;
        }
        return 0;
    }

    /**
     * 在一個物品上解析 tag 類型 double
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    public double getDouble(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final net.minecraft.world.item.ItemStack itemStack = CraftItemStack.asNMSCopy(var1);
        final NBTTagCompound tag = itemStack.e() ? itemStack.s() : new NBTTagCompound();

        if (tag != null && tag.e(var2)) {
            final NBTTagCompound compound = tag.p(var2);
            return compound.e(var3) ? compound.k(var3) : 0;
        }
        return 0D;
    }

    /**
     * 在一個物品上解析 tag 類型 float
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    public float getFloat(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final net.minecraft.world.item.ItemStack itemStack = CraftItemStack.asNMSCopy(var1);
        final NBTTagCompound tag = itemStack.e() ? itemStack.s() : new NBTTagCompound();

        if (tag != null && tag.e(var2)) {
            final NBTTagCompound compound = tag.p(var2);
            return compound.e(var3) ? compound.j(var3) : 0F;
        }
        return 0F;
    }

    /**
     * 在一個物品上解析 tag 類型 int
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    public int getInt(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final net.minecraft.world.item.ItemStack itemStack = CraftItemStack.asNMSCopy(var1);
        final NBTTagCompound tag = itemStack.e() ? itemStack.s() : new NBTTagCompound();

        if (tag != null && tag.e(var2)) {
            final NBTTagCompound compound = tag.p(var2);
            return compound.e(var3) ? compound.h(var3) : 0;
        }
        return 0;
    }

    /**
     * 在一個物品上解析 tag 類型 long
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    public long getLong(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final net.minecraft.world.item.ItemStack itemStack = CraftItemStack.asNMSCopy(var1);
        final NBTTagCompound tag = itemStack.e() ? itemStack.s() : new NBTTagCompound();

        if (tag != null && tag.e(var2)) {
            final NBTTagCompound compound = tag.p(var2);
            return compound.e(var3) ? compound.i(var3) : 0L;
        }
        return 0L;
    }

    /**
     * 在一個物品上解析 tag 類型 short
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    public short getShort(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final net.minecraft.world.item.ItemStack itemStack = CraftItemStack.asNMSCopy(var1);
        final NBTTagCompound tag = itemStack.e() ? itemStack.s() : new NBTTagCompound();

        if (tag != null && tag.e(var2)) {
            final NBTTagCompound compound = tag.p(var2);
            return compound.e(var3) ? compound.g(var3) : 0;
        }
        return 0;
    }

    /**
     * 在一個物品上解析 tag 類型 String
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    @NotNull
    public String getString(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final net.minecraft.world.item.ItemStack itemStack = CraftItemStack.asNMSCopy(var1);
        final NBTTagCompound tag = itemStack.e() ? itemStack.s() : new NBTTagCompound();

        if (tag != null && tag.e(var2)) {
            final NBTTagCompound compound = tag.p(var2);
            return compound.e(var3) ? compound.l(var3) : "";
        }
        return "";
    }

    /**
     * 檢查是否包含一個路徑
     * @param var1 物品
     * @param var2 主路徑
     * @return 資料
     */
    public boolean hasTag(final @NotNull ItemStack var1, final @NotNull String var2) {
        final net.minecraft.world.item.ItemStack itemStack = CraftItemStack.asNMSCopy(var1);
        final NBTTagCompound tag1 = itemStack.s() != null ? itemStack.s() : new NBTTagCompound();
        return tag1.e(var2);
    }

}
