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

package com.moubieapi.api.inventory;

import com.moubieapi.api.inventory.gui.GUI;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個具有返回介面的介面
 * @param <G> 有關 GUI 的類
 * @author MouBieCat
 */
public interface Backable<G extends GUI> {

    /**
     * 獲取返回介面的實例
     * @return 上一層介面
     */
    @NotNull G getBacker();

    /**
     * 返回上一層介面
     * @param player 玩家
     */
    void goBack(@NotNull Player player);

}
