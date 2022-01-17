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

package com.moubieapi.moubieapi.nbttag;

import com.moubieapi.api.builder.ItemNBTBuilder;
import com.moubieapi.moubieapi.itemstack.ItemStackBuilder;
import net.minecraft.nbt.NBTTagCompound;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個物品對 NBTTag 的操作類
 * @author MouBieCat
 */
public final class ItemStackNBTTagBuilder
        extends NBTTagBuilder<ItemStack>
        implements ItemNBTBuilder {

    /**
     * 建構子
     * @param builder 建構的對象
     * @param mainTagName 標籤主路徑
     */
    public ItemStackNBTTagBuilder(final @NotNull ItemStack builder, final @NotNull String mainTagName) {
        super(builder, mainTagName);
    }

    /**
     * 建構出的對象實例
     * @return 建構對象
     */
    @NotNull
    public ItemStack build() {
        final NBTTagCompound tag = ItemStackNBTTagBuilder.Helper.getNBTTag(this.builder);
        // 將當前的配置寫入物品Tag
        tag.a(this.mainTagName, this.compound);
        return Helper.setNBTTag(this.builder, tag);
    }

    /**
     * 在一個物品上解析 tag 類型 boolean
     * @param var1 物品
     * @param var2 主路徑
     * @param var3 路徑
     * @return 資料
     */
    public static boolean getBoolean(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final NBTTagCompound tag = Helper.getNBTTag(var1);
        if (tag.e(var2)) {
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
    public static byte getByte(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final NBTTagCompound tag = Helper.getNBTTag(var1);
        if (tag.e(var2)) {
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
    public static double getDouble(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final NBTTagCompound tag = Helper.getNBTTag(var1);
        if (tag.e(var2)) {
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
    public static float getFloat(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final NBTTagCompound tag = Helper.getNBTTag(var1);
        if (tag.e(var2)) {
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
    public static int getInt(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final NBTTagCompound tag = Helper.getNBTTag(var1);
        if (tag.e(var2)) {
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
    public static long getLong(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final NBTTagCompound tag = Helper.getNBTTag(var1);
        if (tag.e(var2)) {
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
    public static short getShort(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final NBTTagCompound tag = Helper.getNBTTag(var1);
        if (tag.e(var2)) {
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
    public static String getString(final @NotNull ItemStack var1, final @NotNull String var2, final @NotNull String var3) {
        final NBTTagCompound tag = Helper.getNBTTag(var1);
        if (tag.e(var2)) {
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
    public static boolean hasTag(final @NotNull ItemStack var1, final @NotNull String var2) {
        final NBTTagCompound nbtTag = Helper.getNBTTag(var1);
        return nbtTag.e(var2);
    }

    /**
     * 將一些實用應用程序定義在該類別
     * @author MouBieCat
     */
    public static class Helper {
        /**
         * 獲取該物品上記錄的NBTTag
         * @param original 物品
         * @return NBTTag
         */
        @NotNull
        public static NBTTagCompound getNBTTag(final @NotNull ItemStack original) {
            final net.minecraft.world.item.ItemStack itemStack = ItemStackBuilder.Helper.asNMSCopy(original);
            final NBTTagCompound tagCompound = itemStack.s();
            return tagCompound != null ? tagCompound : new NBTTagCompound();
        }

        /**
         * 將 NBTTag 寫入至物品
         * @param original 物品
         * @param compound NBTTag
         * @return 新物品
         */
        @NotNull
        public static ItemStack setNBTTag(final @NotNull ItemStack original, final @NotNull NBTTagCompound compound) {
            final net.minecraft.world.item.ItemStack itemStack = ItemStackBuilder.Helper.asNMSCopy(original);
            itemStack.c(compound);
            return ItemStackBuilder.Helper.asBukkitCopy(itemStack);
        }
    }

}
