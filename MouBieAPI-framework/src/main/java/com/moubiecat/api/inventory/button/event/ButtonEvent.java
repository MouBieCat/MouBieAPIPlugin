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

import com.moubiecat.api.inventory.button.Button;
import com.moubiecat.api.inventory.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.jetbrains.annotations.NotNull;

/**
 * 代表按鈕事件
 * @author MouBieCat
 */
    public abstract class ButtonEvent<B extends Button> {

        // 介面
        @NotNull
    private final GUI gui;

    // 玩家
    @NotNull
    private final Player player;

    // 按鈕
    @NotNull
    private final B button;

    // 點擊方法
    @NotNull
    private final ClickType clickType;

    /**
     * 建構子
     * @param gui 介面
     * @param player 玩家
     * @param button 按鈕
     * @param clickType 點擊方法
     */
    public ButtonEvent(final @NotNull GUI gui,
                       final @NotNull Player player,
                       final @NotNull B button,
                       final @NotNull ClickType clickType) {
        this.gui = gui;
        this.player = player;
        this.button = button;
        this.clickType = clickType;
    }

    /**
     * 獲取事件中的介面
     * @return 介面
     */
    @NotNull
    public final GUI getGUI() {
        return this.gui;
    }

    /**
     * 獲取事件中的玩家
     * @return 玩家
     */
    @NotNull
    public final Player getPlayer() {
        return this.player;
    }

    /**
     * 獲取事件中的按鈕
     * @return 按鈕
     */
    @NotNull
    public final B getButton() {
        return this.button;
    }

    /**
     * 獲取事件點擊方法
     * @return 點擊方法
     */
    @NotNull
    public final ClickType getClickType() {
        return this.clickType;
    }

}
