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

package com.moubiecat.api.inventory;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個帶有頁數的介面
 * @author MouBieCat
 */
public interface Pageable
        extends Openable {

    /**
     * 開啟一個介面(不指定頁數開起第一頁)
     * @param player 玩家
     */
    void open(@NotNull Player player);

    /**
     * 開啟一個介面的頁數
     * @param player 玩家
     * @param page 頁數
     */
    void open(@NotNull Player player, int page);

    /**
     * 獲取當前頁數
     * @return 頁數
     */
    int getPage();

    /**
     * 開啟下一頁
     * @param player 玩家
     */
    void next(@NotNull Player player);

    /**
     * 開啟上一頁
     * @param player 玩家
     */
    void previousPage(@NotNull Player player);

}
