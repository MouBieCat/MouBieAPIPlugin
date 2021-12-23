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

import com.cat.moubieapi.api.gui.Openable;
import com.cat.moubieapi.moubie.gui.UInventoryAbstract;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個基本的介面的介面(#
 * @author MouBieCat
 */
public interface GUI
        extends InventoryHolder, Openable {

    /**
     * 獲取介面大小
     * @return 大小
     */
    @NotNull UInventoryAbstract.InventorySize getGUISize();

    /**
     * 獲取介面標題
     * @return 標題
     */
    @NotNull String getGUITitle();

    /**
     * 代表當介面被點擊的事件
     * @param event 介面點擊事件
     * @return 回傳false不繼續運行
     */
    boolean clickInventory(final @NotNull InventoryClickEvent event);

    /**
     * 代表當介面被開啟的事件
     * @param event 介面點擊事件
     */
    void openInventory(final @NotNull InventoryOpenEvent event);

    /**
     * 代表當介面被關閉的事件
     * @param event 介面點擊事件
     */
    void closeInventory(final @NotNull InventoryCloseEvent event);

    /**
     * 是否取消點擊事件操作 (使物品不被移動)
     * @return 是否取消
     */
    boolean isCancelClickEvent();

    /**
     * 關閉伺服器玩家開啟有關該庫存的介面
     */
    static void closePlayerInventory() {
        UInventoryAbstract.closePlayerInventory();
    }

}
