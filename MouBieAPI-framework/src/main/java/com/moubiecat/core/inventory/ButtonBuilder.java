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

import com.moubiecat.api.inventory.button.Button;
import com.moubiecat.core.itemstack.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 代表一個介面按鈕類別
 * @author MouBieCat
 */
public class ButtonBuilder
        extends ItemStackBuilder
        implements Button {

    // 介面位置
    protected int slotId;

    // 點選方法
    @NotNull
    protected List<ClickType> clickTypes = new ArrayList<>();

    // 是否取消點擊事件
    protected boolean cancelClickEvent = true;

    /**
     * 建構子
     * @param material 材質
     * @param slot 介面位置
     */
    public ButtonBuilder(final @NotNull Material material, final int slot) {
        this(material, 1, slot);
    }

    /**
     * 建構子
     * @param material 材質
     * @param amount 數量
     * @param slot 介面位置
     */
    public ButtonBuilder(final @NotNull Material material, final int amount, final int slot) {
        this(new ItemStack(material, amount), slot);
    }

    /**
     * 建構子
     * @param itemStack 物品實例
     * @param slot 介面位置
     */
    public ButtonBuilder(final @NotNull ItemStack itemStack, final int slot) {
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
    public final boolean isCancelEvent() {
        return this.cancelClickEvent;
    }

    /**
     * 獲取點擊的方法
     * @return 點擊方法
     */
    @NotNull
    public final List<ClickType> getClickType() {
        return this.clickTypes;
    }

}
