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

package com.cat.moubieapi.api.gui.ui;

import com.cat.moubieapi.api.gui.button.Button;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個 GUI 建構器介面
 * @author MouBieCat
 */
public interface GUIBuilder
        extends GUI {

    /**
     * 添加一個按鈕到介面
     * @param uItem 介面物品實例
     */
    @NotNull GUIBuilder addUItem(final @NotNull Button uItem);

    /**
     * 添加一個物品到介面
     * @param itemStack 物品
     */
    @NotNull GUIBuilder addItem(final @NotNull ItemStack itemStack);

    /**
     * 添加一個物品到介面
     * @param itemStack 物品
     * @param slot 位置
     * @return 當前的建構器
     */
    @NotNull GUIBuilder addItem(final @NotNull ItemStack itemStack, final int slot);

    /**
     * 設定是否取消點擊事件操作
     * @param isCancel 是否取消任務 (使物品不被移動)
     */
    void setCancelClickEvent(final boolean isCancel);

    /**
     * 清除當前介面上的所有物品按鈕
     */
    void clearInventory();

}
