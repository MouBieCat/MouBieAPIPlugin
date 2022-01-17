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

package com.moubieapi.api.inventory.gui;

import org.bukkit.event.inventory.InventoryEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 代表使用者介面處理程序
 * @author MouBieCat
 */
public interface GUIHandler {

    /**
     * 運行事件方法
     * @param event 事件實例
     */
    void executeListener(final @NotNull InventoryEvent event, final @NotNull GUIRegister.EventType type);

    /**
     * 獲取正在處理介面
     * @return 介面
     */
    @NotNull GUI getHandler();

}
