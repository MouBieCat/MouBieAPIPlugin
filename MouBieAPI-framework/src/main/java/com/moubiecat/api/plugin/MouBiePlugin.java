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

package com.moubiecat.api.plugin;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個沫白插件
 * @author MouBieCat
 */
public interface MouBiePlugin
        extends Plugin {

    /**
     * 獲取插件加載器
     * @return 加載器
     */
    @NotNull PluginLoader getLoader();

    /**
     * 獲取紀錄器
     * @return 紀錄器
     */
    @NotNull PluginDebugger getDebugger();

}
