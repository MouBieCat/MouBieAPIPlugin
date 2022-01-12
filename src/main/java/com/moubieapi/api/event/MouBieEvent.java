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

package com.moubieapi.api.event;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;

/**
 * 代表自製插件事件抽象類別
 * @author MouBieCat
 */
public abstract class MouBieEvent
        extends Event {

    /**
     * 建構子
     * @param call 是否直接進行呼叫
     */
    public MouBieEvent(final boolean call) {
        if (call)
            this.call();
    }

    /**
     * 調用事件
     */
    public final void call() {
        Bukkit.getPluginManager().callEvent(this);
    }

}
