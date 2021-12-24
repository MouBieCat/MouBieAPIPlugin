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

import com.moubiecat.api.inventory.button.BackButton;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 代表一個介面返回按鈕
 * @author MouBieCat
 */
public final class BackUItemStack
        extends MagicUItemStackAbstract
        implements BackButton {

    /**
     * 建構子
     * @param slot        介面位置
     * @param displayName 顯示名稱
     * @param lore        顯示說明
     */
    public BackUItemStack(final int slot, final @NotNull String displayName, final @Nullable List<String> lore) {
        super(Material.PAPER, slot, displayName, lore);
    }

    /**
     * 建構子
     * @param material    材質
     * @param slot        介面位置
     * @param displayName 顯示名稱
     * @param lore        顯示說明
     */
    public BackUItemStack(final @NotNull Material material, final int slot, final @NotNull String displayName, final @Nullable List<String> lore) {
        super(material, slot, displayName, lore);
    }

}
