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

package com.moubieapi.api.inventory.gui;

import com.moubieapi.api.inventory.InventorySize;
import com.moubieapi.api.inventory.Openable;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;
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
     * 當介面被開啟要做的事情
     * @param event 介面開啟事件
     */
    void openInventory(@NotNull InventoryOpenEvent event);

    /**
     * 當介面被點擊要做的事情
     * @param event 介面點擊事件
     * @return 是否繼續子類複寫的運行
     */
    boolean clickInventory(@NotNull InventoryClickEvent event);

    /**
     * 當介面被關閉要做的事情
     * @param event 介面關閉事件
     */
    void closeInventory(@NotNull InventoryCloseEvent event);


}
