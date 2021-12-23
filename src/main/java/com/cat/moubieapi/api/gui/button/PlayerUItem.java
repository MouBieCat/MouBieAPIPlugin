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

package com.cat.moubieapi.api.gui.button;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個有關玩家建置的物品按鈕
 * @author MouBieCat
 */
public interface PlayerUItem
        extends Button {

    /**
     * 將物品建置出來
     * @return 物品
     */
    @Deprecated
    @NotNull ItemStack build();

    /**
     * 將物品建置出來
     * @param player 玩家
     * @return 物品
     */
    @NotNull ItemStack build(final @NotNull Player player);

}
