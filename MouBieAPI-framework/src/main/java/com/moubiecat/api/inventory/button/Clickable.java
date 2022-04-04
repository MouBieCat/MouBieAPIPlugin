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

import com.moubiecat.api.inventory.button.event.ClickButtonEvent;
import org.bukkit.event.inventory.ClickType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 代表一個可點擊的按鈕
 * @author MouBieCat
 */
public interface Clickable
        extends Button {

    /**
     * 當被點擊時調用
     * @param event 點擊事件
     */
    void executeButtonClick(@NotNull ClickButtonEvent event);

    /**
     * 獲取點擊的方法
     * @return 點擊方法
     */
    @NotNull List<ClickType> getButtonClickType();

}
