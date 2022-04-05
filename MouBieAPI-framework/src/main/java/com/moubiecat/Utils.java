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

package com.moubiecat;

import com.moubiecat.api.plugin.MouBiePlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
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
    public static String forMessageToRGB(@NotNull String msg) {
        final Pattern hexPattern = Pattern.compile("<#([A-Fa-f0-9]){6}>");
        Matcher matcher = hexPattern.matcher(msg);

        while (matcher.find()) {
            final ChatColor hexColor = ChatColor.of(matcher.group().substring(1, matcher.group().length() - 1));
            final String before = msg.substring(0, matcher.start());
            final String after = msg.substring(matcher.end());
            msg = before + hexColor + after;
            matcher = hexPattern.matcher(msg);
        }

        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    /**
     * 獲取沫白插件集合
     * @return 插件集合
     */
    @NotNull
    public static List<MouBiePlugin> getMouBiePlugins() {
        final List<MouBiePlugin> plugins = new ArrayList<>();

        for (final Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            if (plugin instanceof MouBiePlugin mouBiePlugin)
                plugins.add(mouBiePlugin);
        }

        return plugins;
    }

    /**
     * 獲取沫白插件
     * @param name 插件名稱
     * @return 沫白插件
     */
    @Nullable
    public static MouBiePlugin getMouBiePlugin(@NotNull String name) {
        final List<MouBiePlugin> plugins = Utils.getMouBiePlugins();

        for (final MouBiePlugin plugin : plugins) {
            if (plugin.getName().equalsIgnoreCase(name))
                return plugin;
        }

        return null;
    }

    /**
     * 重載沫白的插件
     * @param name 插件名稱
     * @return 是否成功重載
     */
    public static boolean reloadMouBiePlugin(@NotNull String name) {
        final @Nullable MouBiePlugin plugin = Utils.getMouBiePlugin(name);
        if (plugin != null) {
            plugin.getLoader().executeReloadAction();
            return true;
        }

        return false;
    }

    /**
     * 呼叫事件並且返回事件呼叫結果
     * @param event 事件
     * @param <T> 事件類
     * @return 事件呼叫結果
     */
    @NotNull
    public static <T extends Event> T callEvent(@NotNull T event) {
        Bukkit.getPluginManager().callEvent(event);
        return event;
    }

}
