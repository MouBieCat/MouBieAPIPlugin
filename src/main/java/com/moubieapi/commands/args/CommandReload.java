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

package com.moubieapi.commands.args;

import com.moubieapi.MouBieCat;
import com.moubieapi.api.Utils;
import com.moubieapi.api.commands.SenderType;
import com.moubieapi.api.plugin.MouBiePlugin;
import com.moubieapi.moubieapi.commands.CommandNodeAbstract;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

/**
 * 代表插件的重讀指令
 * @author MouBieCat
 */
public final class CommandReload
        extends CommandNodeAbstract {

    /**
     * 建構子
     * @param nodeId      當前節點列數
     * @param nodeName    節點名稱
     */
    public CommandReload(final int nodeId, final @NotNull String nodeName) {
        super(nodeId, nodeName, SenderType.ANY_SENDER, "用於重讀插件的指令參數。", 2);
    }

    /**
     * 運行該節點指令
     * @param sender 發送者
     * @param args   參數
     * @return 是否成功運行
     */
    public boolean onCommand(final @NotNull CommandSender sender, final @NotNull String[] args) {
        if (Utils.reloadMouBiePlugin(args[1])) {
            sender.sendMessage(MouBieCat.PLUGIN_TITLE + "§2您成功對 §6" + args[1] + " §2插件進行了重讀！");
            return true;
        }
        sender.sendMessage(MouBieCat.PLUGIN_TITLE + "§c很抱歉，沒有找到名稱為 §6" + args[1] + " §c的插件。");

        return false;
    }

    /**
     * 運行該節點指令幫助列表
     * @param sender 發送者
     * @param args   參數
     * @return 節點指令幫助列表
     */
    @NotNull
    public List<String> onTab(final @NotNull CommandSender sender, final @NotNull String[] args) {
        final List<MouBiePlugin> mouBiePlugins = new LinkedList<>();

        for (final @NotNull Plugin plugin : Bukkit.getPluginManager().getPlugins())
            if (plugin instanceof MouBiePlugin)
                mouBiePlugins.add((MouBiePlugin) plugin);

        return mouBiePlugins.stream().map(Plugin::getName).toList();
    }

}
