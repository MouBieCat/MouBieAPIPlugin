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

package com.moubiecat.inventory;

import com.moubiecat.api.MouBiePlugin;
import com.moubiecat.api.inventory.Backable;
import com.moubiecat.api.inventory.InventorySize;
import com.moubiecat.api.inventory.button.Button;
import com.moubiecat.api.inventory.gui.GUI;
import com.moubiecat.moubieapi.inventory.UInventoryAbstract;
import com.moubiecat.moubieapi.inventory.UItemStackAbstract;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個受到操作的插件介面
 * @author MouBieCat
 */
public final class PluginOperateInventory
        extends UInventoryAbstract
        implements GUI, Backable<ViewPluginInventory> {

    private static final int DISABLE_BUTTON_SLOT = 10;

    private static final int RELOAD_BUTTON_SLOT = 16;

    private static final int BACK_BUTTON_SLOT = 22;

    // 返回介面
    @NotNull
    private final ViewPluginInventory backerGUI;

    // 代表插件
    @NotNull
    private final MouBiePlugin plugin;

    // 卸載
    @NotNull
    private final Button disableButton = new UItemStackAbstract(Material.MAGENTA_DYE, DISABLE_BUTTON_SLOT) {
        @Override
        @NotNull
        public ItemStack build() {
            // 標題
            this.displayName("§c卸載插件 ！");
            return super.build();
        }
    };

    // 重讀
    @NotNull
    private final Button reloadButton = new UItemStackAbstract(Material.LIME_DYE, RELOAD_BUTTON_SLOT) {
        @Override
        @NotNull
        public ItemStack build() {
            // 標題
            this.displayName("§e重讀插件 ！");
            return super.build();
        }
    };

    // 返回
    @NotNull
    private final Button backButton = new UItemStackAbstract(Material.BARRIER, BACK_BUTTON_SLOT) {
        @Override
        @NotNull
        public ItemStack build() {
            // 標題
            this.displayName("§6返回上一層介面");
            return super.build();
        }
    };

    /**
     * 建構子
     * @param plugin 插件
     */
    public PluginOperateInventory(final @NotNull MouBiePlugin plugin, final @NotNull ViewPluginInventory backer) {
        super(plugin.getName(), InventorySize.THREE);
        this.backerGUI = backer;
        this.plugin = plugin;
    }

    /**
     * 獲取返回介面的實例
     *
     * @return 上一層介面
     */
    @NotNull
    public ViewPluginInventory getBacker() {
        return this.backerGUI;
    }

    /**
     * 返回上一層介面
     */
    public void goBack(final @NotNull Player player) {
        this.backerGUI.open(player, backerGUI.getPage());
    }

    /**
     * 初始化介面
     * @param player 玩家
     */
    @Override
    protected void initInventory(final @NotNull Player player) {
        this.addUItem(this.disableButton)
                .addUItem(this.reloadButton)
                .addUItem(this.backButton);
    }

    /**
     * 當介面被點擊要做的事情
     *
     * @param event 介面點擊事件
     * @return 是否繼續子類複寫的運行
     */
    @Override
    public boolean clickInventory(final @NotNull InventoryClickEvent event) {
        if (!super.clickInventory(event))
            return false;

        final Player player = (Player) event.getWhoClicked();
        final int slot = event.getSlot();
        final ItemStack currentItem = event.getCurrentItem();
        if (currentItem == null)
            return false;

        switch (slot) {
            case DISABLE_BUTTON_SLOT -> {
                Bukkit.getPluginManager().disablePlugin(this.plugin);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
            }
            case RELOAD_BUTTON_SLOT -> {
                this.plugin.onReload();
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
            }
            case BACK_BUTTON_SLOT -> {
                this.goBack(player);
                player.playSound(player.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 1f, 1f);
            }
        }
        return false;
    }

}
