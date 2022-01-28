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

package com.moubieapi.commands;

import com.moubieapi.MouBieCat;
import com.moubieapi.api.commands.CommandNode;
import com.moubieapi.api.commands.SenderType;
import com.moubieapi.commands.args.CommandReload;
import com.moubieapi.moubieapi.commands.CommandMainNodeAbstract;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 代表該插件的主命令
 * @author MouBieCat
 */
public final class CommandMain
        extends CommandMainNodeAbstract {

    /**
     * 建構子
     * @param pluginCommand 插件命令實例
     */
    public CommandMain(final @NotNull PluginCommand pluginCommand) {
        super(pluginCommand, SenderType.ANY_SENDER);

        /* Register Command Nodes */
        this.nextNodes.add("reload", new CommandReload(1, "reload"));
    }

    /**
     * 運行該節點指令
     * @param sender 發送者
     * @param args   參數
     * @return 是否成功運行
     */
    @Override
    public boolean onCommand(final @NotNull CommandSender sender, final @NotNull String[] args) {
        sender.sendMessage(MouBieCat.PLUGIN_TITLE + "§7歡迎使用沫白依賴庫插件，如果有任何插件問題歡迎回報！");
        return true;
    }

    /**
     * 運行該節點指令幫助列表
     *
     * @param sender 發送者
     * @param args   參數
     * @return 節點指令幫助列表
     */
    @Override
    public @NotNull List<String> onTab(final @NotNull CommandSender sender, final @NotNull String[] args) {
        final ArrayList<String> strings = new ArrayList<>();

        for (final CommandNode node : this.nextNodes.getValues())
            strings.add(node.getNodeName());

        return strings;
    }

}
