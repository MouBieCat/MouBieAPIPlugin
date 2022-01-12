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

package com.moubieapi.api.plugin;

import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

/**
 * 代表一個插件紀錄器
 * @author MouBieCat
 */
public interface PluginDebugger {

    /**
     * 紀錄資訊訊息
     * @param msg 訊息
     */
    void info(final @NotNull String msg);

    /**
     * 紀錄警告訊息
     * @param msg 訊息
     */
    void warning(final @NotNull String msg);

    /**
     * 紀錄訊息
     * @param level 級別
     * @param msg 訊息
     */
    void log(final @NotNull Level level, final @NotNull String msg);

}
