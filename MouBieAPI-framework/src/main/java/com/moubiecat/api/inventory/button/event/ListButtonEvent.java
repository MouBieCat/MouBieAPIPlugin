/**
 * LICENSE
 * MouBieAPI
 * -------------
 * Copyright (C) 2022 MouBieCat(MouBie_Yuki)
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

package com.moubiecat.api.inventory.button.event;

import com.moubiecat.api.inventory.button.ListButton;
import com.moubiecat.api.inventory.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.jetbrains.annotations.NotNull;

/**
 * 代表清單按鈕點擊事件
 * @author MouBieCat
 */
public class ListButtonEvent
        extends ButtonEvent<ListButton> {

    /**
     * 建構子
     * @param gui         介面
     * @param player      玩家
     * @param button      按鈕
     * @param clickType   點擊方法
     */
    public ListButtonEvent(final @NotNull GUI gui,
                           final @NotNull Player player,
                           final @NotNull ListButton button,
                           final @NotNull ClickType clickType) {
        super(gui, player, button, clickType);
    }

}
