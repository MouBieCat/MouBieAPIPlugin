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

package com.moubieapi.listener;

import com.moubiecat.api.Utils;
import com.moubiecat.api.event.MouBiePluginDisableEvent;
import com.moubiecat.api.event.MouBiePluginEnableEvent;
import com.moubiecat.api.plugin.MouBiePlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表有關插件事件
 * @author MouBieCat
 */
public final class PluginListener
        implements Listener {

    /**
     * 插件啟用事件
     * @param event 事件
     */
    @EventHandler
    public void onPluginLoad(final @NotNull PluginEnableEvent event) {
        final Plugin plugin = event.getPlugin();

        if (plugin instanceof MouBiePlugin)
            Utils.callEvent(new MouBiePluginEnableEvent((MouBiePlugin) plugin));
    }

    /**
     * 插件關閉事件
     * @param event 事件
     */
    @EventHandler
    public void onPluginDisable(final @NotNull PluginDisableEvent event) {
        final Plugin plugin = event.getPlugin();

        if (plugin instanceof MouBiePlugin)
            Utils.callEvent(new MouBiePluginDisableEvent((MouBiePlugin) plugin));
    }

}
