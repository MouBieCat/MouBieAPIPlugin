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

package com.moubieapi.listener;

import com.moubieapi.api.inventory.gui.GUIHandler;
import com.moubieapi.api.inventory.gui.GUIRegister;
import com.moubieapi.api.inventory.gui.GUI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表該插件需要監聽的介面事件監聽類
 * @author MouBieCat
 */
public final class InventoryListener
        implements Listener {

    /**
     * 當介面被打開
     * @param event 事件
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryOpen(final @NotNull InventoryOpenEvent event) {
        final InventoryHolder holder = event.getInventory().getHolder();
        if (holder instanceof GUI) {
            final GUIHandler eventHandler = ((GUI) holder).getEventHandler();
            eventHandler.executeListener(event, GUIRegister.EventType.OPEN_INVENTORY);
        }
    }

    /**
     * 當介面被點擊
     * @param event 事件
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(final @NotNull InventoryClickEvent event) {
        final InventoryHolder holder = event.getInventory().getHolder();
        final ItemStack currentItem = event.getCurrentItem();
        if (currentItem != null && holder instanceof GUI) {
            final GUIHandler eventHandler = ((GUI) holder).getEventHandler();
            eventHandler.executeListener(event, GUIRegister.EventType.CLICK_INVENTORY);
        }
    }

    /**
     * 當介面被關閉
     * @param event 事件
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClose(final @NotNull InventoryCloseEvent event) {
        final InventoryHolder holder = event.getInventory().getHolder();
        if (holder instanceof GUI) {
            final GUIHandler eventHandler = ((GUI) holder).getEventHandler();
            eventHandler.executeListener(event, GUIRegister.EventType.CLOSE_INVENTORY);
        }
    }

}
