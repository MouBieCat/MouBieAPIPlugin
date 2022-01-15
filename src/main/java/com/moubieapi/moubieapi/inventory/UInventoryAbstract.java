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

import com.moubieapi.api.Utils;
import com.moubieapi.api.inventory.InventorySize;
import com.moubieapi.api.inventory.button.Button;
import com.moubieapi.api.inventory.gui.GUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個使用者介面類別
 * @author MouBieCat
 */
public abstract class UInventoryAbstract
        implements GUI {

    // 介面本身
    @NotNull
    protected final Inventory inventory;

    // 標題
    @NotNull
    private final String inventory_title;

    // 大小
    @NotNull
    private final InventorySize inventory_size;

    // 是否取消事件的操作(使介面不被更動 預設=true)
    private boolean inventory_cancelEvent = true;

    /**
     * 建構子
     * @param title 介面標題
     * @param size 介面大小
     */
    public UInventoryAbstract(final @NotNull String title, final @NotNull InventorySize size) {
        this.inventory_title = Utils.forMessageToRGB(title);
        this.inventory_size = size;
        this.inventory = Bukkit.createInventory(this, this.inventory_size.getSize(), this.inventory_title);
    }

    /**
     * 獲取介面大小
     * @return 大小
     */
    @NotNull
    public final InventorySize getGUISize() {
        return this.inventory_size;
    }

    /**
     * 獲取介面標題
     * @return 標題
     */
    @NotNull
    public final String getGUITitle() {
        return this.inventory_title;
    }

    /**
     * Get the object's inventory.
     * @return The inventory.
     */
    @NotNull
    public final Inventory getInventory() {
        return this.inventory;
    }

    /**
     * 設定是否可以移動該介面的物品
     * @param isCanMove 可以移動的
     */
    public final void setCancelClickEvent(final boolean isCanMove) {
        this.inventory_cancelEvent = isCanMove;
    }

    /**
     * 是否可以移動該介面的物品
     * @return 是否可以
     */
    public final boolean isCancelClickEvent() {
        return this.inventory_cancelEvent;
    }

    /**
     * 清除當前介面上的所有物品按鈕
     */
    public final void clearInventory() {
        final ItemStack airItemStack = new ItemStack(Material.AIR);
        for (int slot = 0; slot < this.inventory_size.getSize(); slot++)
            this.inventory.setItem(slot, airItemStack);
    }

    /**
     * 添加一個按鈕到介面
     * @param uItem 介面物品實例
     */
    @NotNull
    public final UInventoryAbstract addUItem(final @NotNull Button uItem) {
        this.inventory.setItem(uItem.getSlotId(), uItem.build());
        return this;
    }

    /**
     * 添加一個物品到介面
     * @param itemStack 物品
     * @return 當前的建構器
     */
    @NotNull
    public final UInventoryAbstract addItem(final @NotNull ItemStack itemStack) {
        this.inventory.addItem(itemStack);
        return this;
    }

    /**
     * 添加一個物品到介面
     * @param itemStack 物品
     * @param slot 位置
     * @return 當前的建構器
     */
    @NotNull
    public final UInventoryAbstract addItem(final @NotNull ItemStack itemStack, final int slot) {
        this.inventory.setItem(slot, itemStack);
        return this;
    }

    /**
     * 開啟一個介面
     * @param player 玩家
     */
    @Override
    public final void open(final @NotNull Player player) {
        player.openInventory(this.inventory);
        this.initInventory(player);
    }

    /**
     * 初始化介面
     * @param player 玩家
     */
    protected abstract void initInventory(final @NotNull Player player);

}
