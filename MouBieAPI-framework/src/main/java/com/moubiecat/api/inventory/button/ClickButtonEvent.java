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

package com.moubiecat.api.inventory.button;

import com.moubiecat.api.inventory.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.jetbrains.annotations.NotNull;

/**
 * 代表GUI按鈕點擊事件
 * @author MouBieCat
 */
public final class ClickButtonEvent {

    // 事件GUI
    @NotNull
    private final GUI gui;

    // 點擊者
    @NotNull
    private final Player player;

    // 點擊方式類型陣列
    @NotNull
    private final ClickType clickTypes;

    // 點擊位置
    private final int slot;

    /**
     * 建構子
     * @param gui 事件介面
     * @param type 事件點擊類型
     * @param player 事件玩家
     */
    public ClickButtonEvent(@NotNull GUI gui, @NotNull ClickType type, @NotNull Player player, int slot) {
        this.gui = gui;
        this.clickTypes = type;
        this.player = player;
        this.slot = slot;
    }

    /**
     * 獲取事件介面
     * @return GUI
     */
    @NotNull
    public GUI getGUI() {
        return this.gui;
    }

    /**
     * 獲取事件點擊方式
     * @return 點擊類型
     */
    @NotNull
    public ClickType getClickTypes() {
        return this.clickTypes;
    }

    /**
     * 獲取點擊者
     * @return 玩家
     */
    @NotNull
    public Player getPlayer() {
        return this.player;
    }

    /**
     * 獲取點擊位置
     * @return 位置ID
     */
    public int getSlot() {
        return this.slot;
    }

}
