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

import com.moubieapi.api.commands.CommandNode;
import com.moubieapi.api.commands.SenderType;
import com.moubieapi.api.manager.NodeManager;
import com.moubieapi.moubieapi.manager.CommandNodeManager;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一個插件指令的節點
 * @author MouBieCat
 */
public abstract class CommandNodeAbstract
        implements CommandNode {

    // 當前節點列數
    private final int nodeId;

    // 節點名稱(也是指令名稱)
    @NotNull
    private final String nodeName;

    // 節點權限
    @Nullable
    private final Permission permission;

    // 節點發送者類型
    @NotNull
    private final SenderType senderType;

    // 節點說明
    @NotNull
    private final String description;

    // 該指令長度
    private final int commandLength;

    // 代表下一個節點管理器
    @NotNull
    protected final NodeManager<CommandNode> nextNodes = new CommandNodeManager();

    /**
     * 建構子
     * @param nodeId 當前節點列數
     * @param nodeName 節點名稱
     * @param senderType 節點發送者類型
     * @param description 節點說明
     */
    public CommandNodeAbstract(final int nodeId,
                               final @NotNull String nodeName,
                               final @NotNull SenderType senderType,
                               final @NotNull String description,
                               final int argsLength) {
        this(nodeId, nodeName, null, senderType, description, argsLength);
    }

    /**
     * 建構子
     * @param nodeId 當前節點列數
     * @param nodeName 節點名稱
     * @param permission 節點權限
     * @param senderType 節點發送者類型
     * @param description 節點說明
     */
    public CommandNodeAbstract(final int nodeId,
                               final @NotNull String nodeName,
                               final @Nullable String permission,
                               final @NotNull SenderType senderType,
                               final @NotNull String description,
                               final int argsLength) {
        this.nodeId = nodeId;
        this.nodeName = nodeName;
        this.permission = permission != null ? new Permission(permission) : null;
        this.senderType = senderType;
        this.description = description;
        this.commandLength = argsLength;
    }

    /**
     * 獲取當前節點列數
     * @return 列數
     */
    public final int getNodeId() {
        return this.nodeId;
    }

    /**
     * 獲取節點名稱(指令名稱)
     * @return 名稱
     */
    @NotNull
    public final String getNodeName() {
        return this.nodeName;
    }

    /**
     * 獲取下一格節點
     * @param transfer 節點查找傳遞物件
     * @return 下一個節點
     */
    @Nullable
    public final CommandNode next(final @NotNull NodeTransfer transfer) {
        if (transfer.getNextNodeId() >= this.nodeId && transfer.getCommandLength() >= this.commandLength) {

            final CommandNode node = nextNodes.get(transfer.getNodeArgs()[this.nodeId]);

            if (node != null)
                return node.next(new NodeTransfer(node.getNodeId(), transfer.getNodeArgs()));

            return this;
        }

        return null;
    }

    /**
     * 獲取指令權限
     * @return 權限
     */
    @Nullable
    public final Permission getPermission() {
        return this.permission;
    }

    /**
     * 獲取指令發送者類型
     * @return 發送者類型
     */
    @NotNull
    public final SenderType getSenderType() {
        return this.senderType;
    }

    /**
     * 獲取指令說明
     * @return 說明
     */
    @NotNull
    public final String getDescription() {
        return this.description;
    }

    /**
     * 獲取指令所需長度
     * @return 長度
     */
    public final int getCommandLength() {
        return this.commandLength;
    }

    /**
     * 檢查指令發送者身分是否可運行該節點
     * @param sender 發送者
     * @param args 指令參數
     * @return 是否可執行該節點
     */
    public boolean checkCommand(final @NotNull CommandSender sender, final @NotNull String[] args) {
        return this.checkPermission(sender) && this.checkSenderType(sender) && this.checkCommandLength(args);
    }

    /**
     * 檢查指令發送者身分是否可運行該節點
     * @param sender 發送者
     * @param args 指令參數
     * @return 是否可執行該節點
     */
    public boolean checkTab(final @NotNull CommandSender sender, final @NotNull String[] args) {
        return this.checkPermission(sender) && this.checkSenderType(sender) && this.checkCommandLength(args);
    }

    /**
     * 檢查指令發送者的類型
     * @param sender 發送者
     * @return 是否符合類型
     */
    protected final boolean checkSenderType(final @NotNull CommandSender sender) {
        switch (this.senderType) {
            case PLAYER_SENDER -> { return (sender instanceof Player); }
            case CONSOLE_SENDER -> { return (sender instanceof ConsoleCommandSender); }
            case BLOCK_SENDER -> { return (sender instanceof BlockCommandSender); }
            case ANY_SENDER -> { return true; }
        }
        return false;
    }

    /**
     * 檢查指令發送者權限
     * @param sender 發送者
     * @return 是否擁有權限
     */
    protected final boolean checkPermission(final @NotNull CommandSender sender) {
        if (this.permission != null)
            return sender.hasPermission(this.permission);

        return true;
    }

    /**
     * 檢查指令參數的長度是否符合
     * @param args 指令參數
     * @return 是否符合
     */
    protected final boolean checkCommandLength(final @NotNull String[] args) {
        return args.length <= this.commandLength;
    }

}
