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

import com.moubieapi.api.builder.ItemNBTBuilder;
import com.moubieapi.api.inventory.button.Button;
import com.moubieapi.moubieapi.itemstack.ItemStackBuilder;
import com.moubieapi.moubieapi.nbttag.ItemStackNBTTagBuilder;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個介面按鈕類別
 * @author MouBieCat
 */
public class UItemStackBuilder
        extends ItemStackBuilder
        implements Button {

    // 介面物品主要TAG
    protected static final String MOU_BIE_UI_ITEM_STACK_MAIN_TAG = "MOU_BIE_UI_ITEM_STACK_MAIN_TAG";

    // 介面物品是否能移動物品TAG
    private static final String MOU_BIE_UI_ITEM_STACK_IS_CAN_MOVE_BUTTON_TAG = "button_is_can_move";
    // 介面物品是點擊類型TAG
    private static final String MOU_BIE_UI_ITEM_STACK_CLICK_TYPE_TAG = "button_click_type";

    // 介面位置
    protected int slotId;

    // 點選方法
    @NotNull
    protected ClickType clickType = ClickType.UNKNOWN;

    // 是否可以被移動
    protected boolean isCamMove = false;

    /**
     * 建構子
     * @param material 材質
     * @param slot 介面位置
     */
    public UItemStackBuilder(final @NotNull Material material, final int slot) {
        this(material, 1, slot);
    }

    /**
     * 建構子
     * @param material 材質
     * @param amount 數量
     * @param slot 介面位置
     */
    public UItemStackBuilder(final @NotNull Material material, final int amount, final int slot) {
        this(new ItemStack(material, amount), slot);
    }

    /**
     * 建構子
     * @param itemStack 物品實例
     * @param slot 介面位置
     */
    public UItemStackBuilder(final @NotNull ItemStack itemStack, final int slot) {
        super(itemStack);
        this.slotId = slot;
    }

    /**
     * 獲取物品在介面上的位置
     * @return 位置
     */
    public final int getSlotId() {
        return this.slotId;
    }

    /**
     * 獲取該物品是否可以被移動
     * @return 類型
     */
    public final boolean isCamMoveButton() {
        return this.isCamMove;
    }

    /**
     * 獲取點擊的方法
     * @return 點擊方法
     */
    @NotNull
    public final ClickType getClickType() {
        return this.clickType;
    }

    /**
     * 解析一個物品是否可以被使用者移動
     * @param itemStack 物品
     * @return 是否可被移動
     */
    public static boolean getItemStackCanMove(final @NotNull ItemStack itemStack) {
        if (ItemStackNBTTagBuilder.hasTag(itemStack, MOU_BIE_UI_ITEM_STACK_MAIN_TAG))
            return ItemStackNBTTagBuilder.getBoolean(itemStack, MOU_BIE_UI_ITEM_STACK_MAIN_TAG, MOU_BIE_UI_ITEM_STACK_IS_CAN_MOVE_BUTTON_TAG);

        return false;
    }

    /**
     * 解析一個物品的點擊操作類型
     * @param itemStack 物品
     * @return 類型
     */
    @NotNull
    public static ClickType getItemStackClickType(final @NotNull ItemStack itemStack) {
        if (ItemStackNBTTagBuilder.hasTag(itemStack, MOU_BIE_UI_ITEM_STACK_MAIN_TAG)) {
            return ClickType.valueOf(
                    ItemStackNBTTagBuilder.getString(itemStack, MOU_BIE_UI_ITEM_STACK_MAIN_TAG, MOU_BIE_UI_ITEM_STACK_CLICK_TYPE_TAG)
            );
        }
        return ClickType.UNKNOWN;
    }

    /**
     * 將物品建置出來
     * @return 物品
     */
    @Override
    @NotNull
    public ItemStack build() {
        final ItemNBTBuilder itemNBTBuilder = new ItemStackNBTTagBuilder(this.itemStack, MOU_BIE_UI_ITEM_STACK_MAIN_TAG);

        // 配置 TAG 屬性
        this.itemStack = itemNBTBuilder
                .setBoolean(MOU_BIE_UI_ITEM_STACK_IS_CAN_MOVE_BUTTON_TAG, this.isCamMove)
                .setString(MOU_BIE_UI_ITEM_STACK_CLICK_TYPE_TAG, this.clickType.toString())
                .build();

        return super.build();
    }

}
