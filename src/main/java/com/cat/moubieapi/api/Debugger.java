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

package com.cat.moubieapi.api;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

/**
 * 有關偵錯或是訊息輸出類
 * @author MouBieCat
 */
public final class Debugger {

    /**
     * 發送一般資訊紀錄
     * @param plugin 紀錄插件
     * @param msg 訊息
     */
    public static void info(final @NotNull Plugin plugin, final @NotNull String msg) {
        plugin.getLogger().info(Utils.forMessageToRGB(msg));
    }

    /**
     * 發送嚴重警告紀錄
     * @param plugin 紀錄插件
     * @param msg 訊息
     */
    public static void warning(final @NotNull Plugin plugin, final @NotNull String msg) {
        plugin.getLogger().warning(Utils.forMessageToRGB(msg));
    }

    /**
     * 自訂訊息級別
     * @param plugin 紀錄插件
     * @param level 級別
     * @param msg 訊息
     */
    public static void log(final @NotNull Plugin plugin, final @NotNull Level level, final @NotNull String msg) {
        plugin.getLogger().log(level, Utils.forMessageToRGB(msg));
    }

}
