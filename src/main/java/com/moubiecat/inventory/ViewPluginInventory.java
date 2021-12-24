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
import com.moubiecat.api.inventory.InventorySize;
import com.moubiecat.api.inventory.button.PageButton;
import com.moubiecat.api.inventory.gui.PageGUI;
import com.moubiecat.moubieapi.inventory.PageUInventoryAbstract;
import com.moubiecat.moubieapi.inventory.PageUItemStack;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

/**
 * 代表一個查看插件的使用者介面類別
 * @author MouBieCat
 */
public final class ViewPluginInventory
        extends PageUInventoryAbstract
        implements PageGUI {

    private static final int NEXT_BUTTON_SLOT = 53;

    private static final int PREVIOUS_BUTTON_SLOT = 45;

    // 下一頁按鈕
    @NotNull
    private final PageButton nextButton = new PageUItemStack(NEXT_BUTTON_SLOT, "§c§l>>>", null);

    // 上一頁按鈕
    @NotNull
    private final PageButton previousButton = new PageUItemStack(PREVIOUS_BUTTON_SLOT, "§c§l<<<", null);

    /**
     * 建構子
     */
    public ViewPluginInventory() {
        super("§8MouBieCat Plugin List", InventorySize.SIX);
    }

    /**
     * 初始化介面頁數介面
     * @param player 玩家
     * @param page   頁數
     */
    @Override
    protected void initPageInventory(final @NotNull Player player, final int page) {
        final List<MouBiePlugin> sortPlugins = ViewPluginInventory.getSortPlugins();

        // 如果頁數 >0 則添加上一頁按鈕
        if (page > 0)
            this.addUItem(this.previousButton);

        try {
            int startQuest = page * 36;

            for (int slot = 9; slot < 45; slot++) {
                final MouBiePlugin plugin = sortPlugins.get(startQuest++);
                this.addUItem(new PluginButton(plugin, slot));
            }

        } catch (final Exception ignored) { return; }

        this.addUItem(this.nextButton);
    }

    /**
     * 當介面被點擊要做的事情
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
            case NEXT_BUTTON_SLOT -> {
                this.nextPage(player);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
            }
            case PREVIOUS_BUTTON_SLOT -> {
                this.previousPage(player);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
            }
            default -> {
                final MouBiePlugin plugin = PluginButton.getItemStackPlugin(currentItem);
                if (plugin != null) {
                    new PluginOperateInventory(plugin, this).open(player);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
                }
            }
        }

        return false;
    }

    /**
     * 獲取當前伺服器所有 MouBieAPI 旗下的插件
     * @return 插件排序集合
     */
    @NotNull
    private static List<MouBiePlugin> getSortPlugins() {
        final List<MouBiePlugin> plugins = new LinkedList<>();

        for (final Plugin serverPlugin : Bukkit.getPluginManager().getPlugins()) {
            if (serverPlugin instanceof MouBiePlugin)
                plugins.add((MouBiePlugin) serverPlugin);
        }

        return plugins;
    }

}
