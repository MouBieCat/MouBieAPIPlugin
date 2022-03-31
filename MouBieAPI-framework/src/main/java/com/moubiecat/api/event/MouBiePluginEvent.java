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

package com.moubiecat.api.event;

import com.moubiecat.api.plugin.MouBiePlugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表沫白插件的事件
 * @author MouBieCat
 */
public abstract class MouBiePluginEvent
        extends MouBieEvent {

    // 事件插件
    @NotNull
    private final MouBiePlugin plugin;

    /**
     * 建構子
     * @param plugin 插件
     */
    public MouBiePluginEvent(@NotNull MouBiePlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * 獲取事件的插件
     * @return 插件
     */
    @NotNull
    public MouBiePlugin getPlugin() {
        return this.plugin;
    }

}
