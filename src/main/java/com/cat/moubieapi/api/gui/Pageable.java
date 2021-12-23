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

package com.cat.moubieapi.api.gui;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個有多頁數的介面
 */
public interface Pageable {

    /**
     * 開啟一個特定頁數
     * @param player 玩家
     * @param page 頁數
     */
    void open(final @NotNull Player player, final int page);

    /**
     * 獲取當前頁數
     * @return 頁數
     */
    int getPage();

    /**
     * 翻至下一頁
     * @param player 玩家
     */
    void nextPage(final @NotNull Player player);

    /**
     * 翻至上一頁
     * @param player 玩家
     */
    void previousPage(final @NotNull Player player);

}
