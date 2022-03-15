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

package com.moubiecat.core.plugin;

import com.moubiecat.api.Utils;
import com.moubiecat.api.plugin.MouBiePlugin;
import com.moubiecat.api.plugin.PluginDebugger;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 代表一個插件紀錄器
 * @author MouBieCat
 */
public final class MouBiePluginDebugger
        implements PluginDebugger {

    // 插件
    @NotNull
    private final MouBiePlugin plugin;

    // 紀錄器
    @NotNull
    private final Logger logger;

    /**
     * 建構子
     * @param plugin 插件
     */
    public MouBiePluginDebugger(final @NotNull MouBiePlugin plugin) {
        this.plugin = plugin;
        this.logger = plugin.getLogger();
    }

    /**
     * 紀錄資訊訊息
     * @param msg 訊息
     */
    public void info(final @NotNull String msg) {
        this.logger.info(Utils.forMessageToRGB(msg));
    }

    /**
     * 紀錄警告訊息
     * @param msg 訊息
     */
    public void warning(final @NotNull String msg) {
        this.logger.warning(Utils.forMessageToRGB(msg));
    }

    /**
     * 紀錄訊息
     * @param level 級別
     * @param msg 訊息
     */
    public void log(final @NotNull Level level, final @NotNull String msg) {
        this.logger.log(level, Utils.forMessageToRGB(msg));
    }

    /**
     * 獲取該紀錄器插件
     * @return 插件
     */
    @NotNull
    public MouBiePlugin getPlugin() {
        return this.plugin;
    }

}
