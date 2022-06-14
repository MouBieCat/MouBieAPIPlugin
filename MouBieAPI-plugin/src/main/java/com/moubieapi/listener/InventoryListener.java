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

import com.moubieapi.MouBieCat;
import com.moubiecat.api.inventory.gui.GUI;
import com.moubiecat.core.inventory.UInventoryListenerHandler;
import org.bukkit.Material;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
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

        if (holder instanceof GUI gui)
            this.executeListener(gui, event);
    }

    /**
     * 當介面被點擊
     * @param event 事件
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(final @NotNull InventoryClickEvent event) {
        final InventoryHolder holder = event.getInventory().getHolder();
        final ItemStack currentItem = event.getCurrentItem();

        if (holder instanceof GUI gui && currentItem != null && !currentItem.getType().equals(Material.AIR))
            this.executeListener(gui, event);
    }

    /**
     * 當介面被關閉
     * @param event 事件
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClose(final @NotNull InventoryCloseEvent event) {
        final InventoryHolder holder = event.getInventory().getHolder();

        if (holder instanceof GUI gui)
            this.executeListener(gui, event);
    }

    /**
     * 創建介面事件線程
     * @param gui 觸發介面
     * @param event 事件實例
     */
    private void executeListener(final @NotNull GUI gui, @NotNull InventoryEvent event) {
        final AsyncInventoryEventThread thread = new AsyncInventoryEventThread(gui, event);

        if (UInventoryListenerHandler.GUIHelper.isSynchronous(gui))
            // 同步調用
            thread.run();

        else
            // 異步調用
            thread.runTaskAsynchronously(MouBieCat.getInstance());

        // 是否為可取消事件、事件不是取消狀態
        if (event instanceof Cancellable cancellable && !cancellable.isCancelled())
            cancellable.setCancelled(
                    UInventoryListenerHandler.GUIHelper.isCancelEvent(gui, event.getClass())
            );
    }

    /**
     * 代表異步介面事件線程
     * @author MouBieCat
     */
    private final static class AsyncInventoryEventThread
            extends BukkitRunnable {

        // 觸發介面
        @NotNull
        private final GUI gui;

        // 事件實例
        @NotNull
        private final InventoryEvent event;

        /**
         * 介面事件
         * @param gui 事件介面
         * @param event 事件
         */
        private AsyncInventoryEventThread(final @NotNull GUI gui, final @NotNull InventoryEvent event) {
            this.gui = gui;
            this.event = event;
        }

        /**
         * 運行
         */
        @Override
        public void run() {
            this.gui.getEventHandler().executeListener(this.event);
        }
    }

}
