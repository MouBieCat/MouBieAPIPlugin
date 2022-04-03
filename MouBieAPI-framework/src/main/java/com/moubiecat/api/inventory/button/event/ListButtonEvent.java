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

package com.moubiecat.api.inventory.button.event;

import com.moubiecat.api.inventory.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.jetbrains.annotations.NotNull;

/**
 * 代表清單式按鈕事件
 * @author MouBieCat
 */
public class ListButtonEvent
        extends ClickButtonEvent {

    // 選取項位置
    private final int selectIndex;

    /**
     * 建構子
     * @param gui    事件介面
     * @param type   事件點擊類型
     * @param player 事件玩家
     * @param slot   點擊位置
     * @param index  選取項ID
     */
    public ListButtonEvent(final @NotNull GUI gui, final @NotNull ClickType type, final @NotNull Player player, final int slot, final int index) {
        super(gui, type, player, slot);
        this.selectIndex = index;
    }

    /**
     * 建構子
     * @param event 原事件
     * @param index  選取項ID
     */
    public ListButtonEvent(final @NotNull ClickButtonEvent event, final int index) {
        super(event.getGUI(), event.getClickTypes(), event.getPlayer(), event.getSlot());
        this.selectIndex = index;
    }

    /**
     * 獲取選取項位置
     * @return 位置
     */
    public final int getSelectIndex() {
        return this.selectIndex;
    }

}
