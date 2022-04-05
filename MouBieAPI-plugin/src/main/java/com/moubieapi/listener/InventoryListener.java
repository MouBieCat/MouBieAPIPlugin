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
import com.moubiecat.api.inventory.button.event.ListButtonEvent;
import com.moubiecat.api.inventory.gui.GUI;
import com.moubiecat.api.inventory.gui.GUIEventCancelRegister;
import com.moubiecat.api.inventory.gui.GUIRegister;
import com.moubiecat.api.inventory.gui.InventorySize;
import com.moubiecat.core.inventory.ListButtonBuilder;
import com.moubiecat.core.inventory.UInventoryAbstract;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
            this.createInventoryThread(gui, event);
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
            this.createInventoryThread(gui, event);
    }

    /**
     * 當介面被關閉
     * @param event 事件
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClose(final @NotNull InventoryCloseEvent event) {
        final InventoryHolder holder = event.getInventory().getHolder();

        if (holder instanceof GUI gui)
            this.createInventoryThread(gui, event);
    }

    /**
     * 創建介面事件線程
     * @param gui 觸發介面
     * @param event 事件實例
     */
    private void createInventoryThread(final @NotNull GUI gui, @NotNull InventoryEvent event) {
        // 異步調用事件
        new AsyncInventoryEventThread(gui, event).runTaskAsynchronously(MouBieCat.getInstance());
        // 是否為可取消事件
        if (event instanceof Cancellable cancellable)
            // 設定取消事件，如果介面的 GUIEventCancelRegister 標記帶有該事件類
            cancellable.setCancelled(this.isCancelInventoryEvent(gui, event));
    }

    /**
     * 是否取消事件
     * @param gui 介面
     * @param event 事件
     * @return 是否取消
     */
    private boolean isCancelInventoryEvent(final @NotNull GUI gui, final @NotNull InventoryEvent event) {
        // 獲取介面類
        final @NotNull Class<? extends @NotNull GUI> guiClass = gui.getClass();

        // 如果介面類帶有 GUIEventCancelRegister 標記
        if (guiClass.isAnnotationPresent(GUIEventCancelRegister.class)) {
            // 獲取 GUIEventCancelRegister 標記
            final @NotNull GUIEventCancelRegister cancelRegister = guiClass.getAnnotation(GUIEventCancelRegister.class);
            // 如果標記事件帶有 event，則取消事件
            for (final @NotNull Class<? extends InventoryEvent> cancel : cancelRegister.cancels()) {
                if (cancel.equals(event.getClass()))
                    return true;
            }
        }
        return false;
    }

    /**
     * 代表異步介面事件線程
     * @author MouBieCat
     */
    private static class AsyncInventoryEventThread
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
        public final void run() {
            this.gui.getEventHandler().executeListener(this.event);
        }
    }




    @EventHandler
    public void onDrop(final @NotNull PlayerDropItemEvent event) {
        new CustomGUI().open(event.getPlayer());
    }
    @GUIEventCancelRegister( cancels = { InventoryClickEvent.class } )
    public static class CustomGUI extends UInventoryAbstract {

        private final MyListButton listButton1 = new MyListButton(1);

        /**
         * 建構子
         */
        public CustomGUI() {
            super("&c自訂菜單", InventorySize.ONE);
            this.addUItem(listButton1);
        }

        /**
         * 初始化介面
         * @param player 玩家
         */
        @Override
        protected void initInventory(final @NotNull Player player) {
            this.drawButton(listButton1);
        }

        @GUIRegister
        public void onClose(final @NotNull InventoryCloseEvent event) {
            event.getPlayer().sendMessage("最終結果為：" + this.listButton1.getSelectContent());
        }

        public static class MyListButton extends ListButtonBuilder {
            /**
             * 建構子
             * @param slot     介面位置
             */
            public MyListButton(int slot) {
                super(Material.PAPER, slot);
                this.contents.add(new Content(Material.AZURE_BLUET, "C++"));
                this.contents.add(new Content(Material.BAKED_POTATO, "Java"));
                this.contents.add(new Content(Material.CACTUS, "PHP"));
                this.contents.add(new Content(Material.DAMAGED_ANVIL, "JavaScript"));
                this.contents.add(new Content(Material.EGG, "Python"));
                this.contents.add(new Content(Material.FARMLAND, "ASP.NET"));
            }

            @Override
            protected void onSelectChange(final @NotNull ListButtonEvent event) {
                event.getPlayer().sendMessage("你選擇了：" + this.getContent(event.getSelectIndex()));
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 5f);
            }

            @Override
            public @NotNull ItemStack build() {
                this.displayName("&6清單按鈕");
                this.lore(List.of("&7請選擇一個你目前正在使用的程式語言？"));
                return super.build();
            }
        }
    }

}
