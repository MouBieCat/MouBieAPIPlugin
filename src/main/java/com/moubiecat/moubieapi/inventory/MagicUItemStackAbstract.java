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

package com.moubiecat.moubieapi.inventory;

import com.moubiecat.api.inventory.button.MagicButton;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 代表一個魔術按鈕，通常是GUI常見按鈕類別 (下一頁、上一頁、返回)
 * @author MouBieCat
 */
public abstract class MagicUItemStackAbstract
        extends UItemStackBuilder
        implements MagicButton {

    // 顯示名稱
    @Nullable
    private final String displayName;

    // 顯示說明
    @Nullable
    private final List<String> lore;

    /**
     * 建構子
     * @param material 材質
     * @param slot     介面位置
     */
    public MagicUItemStackAbstract(final @NotNull Material material, final int slot, final @NotNull String displayName, final @Nullable List<String> lore) {
        super(material, slot);
        this.displayName = displayName;
        this.lore = lore;
    }

    /**
     * 建構子
     * @param itemStack 物品實例
     * @param slot 介面位置
     */
    public MagicUItemStackAbstract(final @NotNull ItemStack itemStack, final int slot) {
        super(itemStack, slot);
        this.displayName = null;
        this.lore = null;
    }

    /**
     * 將物品建置出來
     * @return 物品
     */
    @Override
    @NotNull
    public ItemStack build() {
        if (this.getDisplayName() != null)
            this.displayName(this.getDisplayName());

        if (this.getLore() != null)
                this.lore(this.getLore());

        return super.build();
    }

    /**
     * 獲取顯示的名稱
     * @return 名稱
     */
    @Nullable
    public final String getDisplayName() {
        return this.displayName;
    }

    /**
     * 獲取顯示的說明
     * @return 說明
     */
    @Nullable
    public final List<String> getLore() {
        return this.lore;
    }

}
