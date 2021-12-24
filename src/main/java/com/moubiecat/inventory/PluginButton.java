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
import com.moubiecat.moubieapi.inventory.UItemStackAbstract;
import com.moubiecat.moubieapi.itemstack.NBTTagBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 用於顯示插件資訊的按鈕
 * @author MouBieCat
 */
public final class PluginButton
        extends UItemStackAbstract {

    // 插件名稱
    private static final String UI_ITEM_NBT_TAG_PLUGIN_NAME = "PLUGIN_NAME";

    // 插件
    @NotNull
    private final MouBiePlugin plugin;

    /**
     * 建構子
     * @param slot     介面位置
     */
    public PluginButton(final @NotNull MouBiePlugin plugin, final int slot) {
        super(Material.PAPER, 1, slot);
        this.plugin = plugin;
    }

    /**
     * 將物品建置出來
     * @return 物品
     */
    @Override
    @NotNull
    public ItemStack build() {
        // 配置 TAG 屬性
        this.setMainTagName(UItemStackAbstract.UI_ITEM_NBT_TAG_MAIN_PATH)
                .setString(UI_ITEM_NBT_TAG_PLUGIN_NAME, this.plugin.getName());

        // 標題
        this.displayName("§a" + this.plugin.getName());

        return super.build();
    }

    /**
     * 獲取該按鈕所代表的插件
     * @return 插件
     */
    @NotNull
    public MouBiePlugin getPlugin() {
        return this.plugin;
    }

    /**
     * 解析一個物品的代表插件
     * @param itemStack 物品
     * @return 插件
     */
    @Nullable
    public static MouBiePlugin getItemStackPlugin(final @NotNull ItemStack itemStack) {
        if (NBTTagBuilder.hasTag(itemStack, UItemStackAbstract.UI_ITEM_NBT_TAG_MAIN_PATH)) {
            return (MouBiePlugin)
                    Bukkit.getPluginManager().getPlugin(NBTTagBuilder.getString(
                            itemStack, UItemStackAbstract.UI_ITEM_NBT_TAG_MAIN_PATH, UI_ITEM_NBT_TAG_PLUGIN_NAME
                    ));
        }
        return null;
    }

}
