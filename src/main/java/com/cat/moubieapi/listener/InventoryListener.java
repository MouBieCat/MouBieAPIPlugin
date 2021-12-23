/**
 * LICENSE
 * MouBieQuest
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

package com.cat.moubieapi.listener;

import com.cat.moubieapi.api.gui.ui.GUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

/**
 * 有關介面事件監聽都在這
 * @author MouBieCat
 */
public final class InventoryListener
        implements Listener {

    /**
     * 選單開啟事件
     * @param event 事件
     */
    @EventHandler
    public void onOpen(final @NotNull InventoryOpenEvent event) {
        final InventoryHolder holder = event.getInventory().getHolder();

        if (holder instanceof GUI)
            ((GUI)holder).openInventory(event);
    }

    /**
     * 選單被擊事件
     * @param event 事件
     */
    @EventHandler
    public void onClick(final @NotNull InventoryClickEvent event) {
        final InventoryHolder holder = event.getInventory().getHolder();

        if (holder instanceof GUI)
            ((GUI)holder).clickInventory(event);
    }

    /**
     * 選單關閉事件
     * @param event 事件
     */
    @EventHandler
    public void onOpen(final @NotNull InventoryCloseEvent event) {
        final InventoryHolder holder = event.getInventory().getHolder();

        if (holder instanceof GUI)
            ((GUI)holder).closeInventory(event);
    }

}
