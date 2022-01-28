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

package com.moubieapi.api;

import com.moubieapi.api.plugin.MouBiePlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 將一些實用應用程序定義在該類別
 * @author MouBieCat
 */
public final class Utils {

    /**
     * 將字串RGB解析成RGB物件
     * @param msg 十六進位RGB字串 (<#FF0000> Hello world !)
     * @return RGB字串
     */
    public static String forMessageToRGB(final @NotNull String msg) {
        String message = msg;

        final Pattern hexPattern = Pattern.compile("<#([A-Fa-f0-9]){6}>");
        Matcher matcher = hexPattern.matcher(message);

        while (matcher.find()) {
            final ChatColor hexColor = ChatColor.of(matcher.group().substring(1, matcher.group().length() - 1));
            final String before = message.substring(0, matcher.start());
            final String after = message.substring(matcher.end());
            message = before + hexColor + after;
            matcher = hexPattern.matcher(message);
        }

        return message;
    }

    /**
     * 重載沫白的插件
     * @param pluginName 插件名稱
     * @return 是否成功重載
     */
    public static boolean reloadMouBiePlugin(final @NotNull String pluginName) {
        final Plugin plugin = Bukkit.getPluginManager().getPlugin(pluginName);

        if (plugin != null && plugin.isEnabled() && plugin instanceof MouBiePlugin) {
            ((MouBiePlugin)plugin).getLoader().executeReloadAction();
            return true;
        }

        return false;
    }

}
