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

import com.moubieapi.api.commands.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 代表一個插件的主要命令節點
 * @author MouBieCat
 */
public abstract class CommandMainNodeAbstract
        extends CommandNodeAbstract
        implements CommandMainNode {

    /**
     * 建構子
     * @param pluginCommand 插件命令實例
     * @param senderType  節點發送者類型
     */
    public CommandMainNodeAbstract(final @NotNull PluginCommand pluginCommand,
                                   final @NotNull SenderType senderType) {
        super(0, pluginCommand.getName(), pluginCommand.getPermission(), senderType, pluginCommand.getDescription(), 1);
    }

    /**
     * 由 Bukkit 驅動
     * @param sender 指令發送者
     * @param command 指令
     * @param cmdName 指令名稱
     * @param args 參數
     * @return 是否成功運行
     */
    @Override
    public final boolean onCommand(final @NotNull CommandSender sender,
                                   final @NotNull Command command,
                                   final @NotNull String cmdName,
                                   final @NotNull String[] args) {
        // Check Command args, Check Sender Type
        if (this.checkCommand(sender, args))
            return this.onCommand(sender, args);

        else {
            // Create NodeTransfer Object
            final NodeTransfer nodeTransfer = new NodeTransfer(this.getNodeId(), args);

            // Get Next Command Node
            final CommandNode next = this.next(nodeTransfer);

            // Check Command args, Check Sender Type
            if (next != null && next.checkCommand(sender, args))
                return next.onCommand(sender, args);
        }

        return false;
    }

    /**
     * 由 Bukkit 驅動
     * @param sender 指令發送者
     * @param command 指令
     * @param cmdName 指令名稱
     * @param args 參數
     * @return 指令幫助列表
     */
    @NotNull
    public final List<String> onTabComplete(final @NotNull CommandSender sender,
                                            final @NotNull Command command,
                                            final @NotNull String cmdName,
                                            final @NotNull String[] args) {
        // Check Command args
        if (this.checkTab(sender, args))
            return this.onTab(sender, args);

        else {
            // Create NodeTransfer Object
            final NodeTransfer nodeTransfer = new NodeTransfer(this.getNodeId(), args);

            // Get Next Command Node
            final CommandNode next = this.next(nodeTransfer);

            // Check Command args, Check Sender Type
            if (next != null && next.checkTab(sender, args))
                return next.onTab(sender, args);
        }

        return new ArrayList<>();
    }

    /**
     * 檢查指令發送者身分是否可運行該節點
     * @param sender 發送者
     * @param args 指令參數
     * @return 是否可執行該節點
     */
    @Override
    public final boolean checkCommand(final @NotNull CommandSender sender, final @NotNull String[] args) {
        return this.checkPermission(sender) && this.checkSenderType(sender) && args.length == 0;
    }

    /**
     * 檢查指令發送者身分是否可運行該節點
     * @param sender 發送者
     * @param args 指令參數
     * @return 是否可執行該節點
     */
    @Override
    public final boolean checkTab(final @NotNull CommandSender sender, final @NotNull String[] args) {
        return this.checkPermission(sender) && this.checkSenderType(sender) && args.length <= 1;
    }

}
