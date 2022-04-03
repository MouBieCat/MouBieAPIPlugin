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

package com.moubiecat.api.inventory.gui;

import com.moubiecat.api.inventory.Openable;
import com.moubiecat.api.inventory.button.Button;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個使用者介面
 * @author MouBieCat
 */
public interface GUI
        extends Openable, InventoryHolder {

    /**
     * 獲取介面大小
     * @return 大小
     */
    @NotNull InventorySize getGUISize();

    /**
     * 獲取介面標題
     * @return 標題
     */
    @NotNull String getGUITitle();

    /**
     * 獲取事件處理程序
     * @return 事件處理程序
     */
    @NotNull GUIHandler getEventHandler();

    /**
     * 繪製按鈕
     * @param buttons 按鈕
     */
    @NotNull GUI drawButton(final @NotNull Button... buttons);

    /**
     * 繪製物品
     * @param itemStacks 物品
     */
    @NotNull GUI drawItemStack(final @NotNull ItemStack... itemStacks);


    /**
     * 繪製物品
     * @param itemStacks 物品
     */
    @NotNull GUI drawItemStack(final int slotId, final @NotNull ItemStack itemStacks);

}
