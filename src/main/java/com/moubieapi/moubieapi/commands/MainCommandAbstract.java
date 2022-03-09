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

package com.moubieapi.moubieapi.commands;

import com.moubieapi.MouBieCat;
import com.moubieapi.api.commands.MainCommand;
import com.moubieapi.api.commands.SubCommand;
import com.moubieapi.api.manager.CommandManager;
import com.moubieapi.moubieapi.manager.SubCommandManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

/**
 * 代表一個主指令
 * @author MouBieCat
 */
public class MainCommandAbstract
        implements MainCommand {

    // 子指令管理器
    @NotNull
    protected final SubCommandManager commandManager = new SubCommandManager();

    /**
     * 運行該指令
     * @param sender  發送者
     * @param command 指令
     * @param cmd     指令名
     * @param args    參數
     * @return 節點指令幫助列表
     */
    @Override
    public final boolean onCommand(final @NotNull CommandSender sender, final @NotNull Command command, final @NotNull String cmd, final @NotNull String[] args) {
        if (args.length >= 1) {
            final @Nullable SubCommand subCommand = this.commandManager.get(args[0]);

            if (subCommand != null)
                return subCommand.onCmd(sender, args);

        }

        return this.onCmd(sender, args);
    }

    /**
     * 運行該指令幫助列表
     * @param sender  發送者
     * @param command 指令
     * @param cmd     指令名
     * @param args    參數
     * @return 節點指令幫助列表
     */
    @NotNull
    public final List<String> onTabComplete(final @NotNull CommandSender sender, final @NotNull Command command, final @NotNull String cmd, final @NotNull String[] args) {
        if (args.length >= 1) {
            final @Nullable SubCommand subCommand = this.commandManager.get(args[0]);

            if (subCommand != null)
                return subCommand.onTab(sender, args);
        }

        return this.onTab(sender, args);
    }

    /**
     * 運行該節點指令
     * @param sender  發送者
     * @param args    參數
     * @return 是否成功運行
     */
    public boolean onCmd(final @NotNull CommandSender sender, final @NotNull String[] args) {
        sender.sendMessage(MouBieCat.PLUGIN_TITLE + "§7歡迎使用沫白依賴庫插件，如果有任何插件問題歡迎回報！");
        return true;
    }

    /**
     * 運行該節點指令幫助列表
     * @param sender 發送者
     * @param args 參數
     * @return 節點指令幫助列表
     */
    @NotNull
    public List<String> onTab(final @NotNull CommandSender sender, final @NotNull String[] args) {
        final Collection<SubCommand> commands = this.commandManager.getValues();
        return commands.stream().map(SubCommand::getName).toList();
    }

    /**
     * 獲取子指令管理器
     * @return 管理器
     */
    @NotNull
    public final CommandManager getSubCommandManager() {
        return this.commandManager;
    }

}
