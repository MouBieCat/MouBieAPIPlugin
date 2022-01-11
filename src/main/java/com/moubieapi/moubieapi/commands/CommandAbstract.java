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

import com.moubieapi.api.commands.Command;
import com.moubieapi.api.commands.SenderType;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一個指令的基礎類別
 * @author MouBieCat
 */
public abstract class CommandAbstract
        implements Command {

    @NotNull
    private final String name;

    @NotNull
    private final String description;

    @NotNull
    private final SenderType senderType;

    @Nullable
    private Permission permission;

    /**
     * 建構子
     * @param name 指令名稱
     * @param description 說明
     * @param senderType 發送者類型
     */
    public CommandAbstract(final @NotNull String name, final @NotNull String description, final @NotNull SenderType senderType) {
        this.name = name;
        this.description = description;
        this.senderType = senderType;
    }

    /**
     * 建構子
     * @param name 指令名稱
     * @param description 說明
     * @param senderType 發送者類型
     * @param permission 權限
     */
    public CommandAbstract(final @NotNull String name, final @NotNull String description, final @NotNull SenderType senderType, final @Nullable Permission permission) {
        this.name = name;
        this.description = description;
        this.senderType = senderType;
        this.permission = permission;
    }

    /**
     * 獲取指令名稱
     * @return 名稱
     */
    @NotNull
    public String getCommandName() {
        return this.name;
    }

    /**
     * 獲取指令說明
     * @return 說明
     */
    @NotNull
    public String getDescription() {
        return this.description;
    }

    /**
     * 獲取可發送者類型
     * @return 發送者類型
     */
    @NotNull
    public SenderType getSenderType() {
        return this.senderType;
    }

    /**
     * 獲取運行所需權限
     * @return 權限
     */
    @Nullable
    public Permission getPermission() {
        return this.permission;
    }

    /**
     * 判斷一個發送者的權限
     * @param sender 發送者
     * @return 是否擁有該權限
     */
    protected final boolean hasPermission(final @NotNull CommandSender sender) {
        if (this.permission != null)
            return sender.hasPermission(String.valueOf(this.permission));

        return true;
    }

    /**
     * 檢查指令發送者是否符合類型
     * @param sender 發送者
     * @return 是否符合
     */
    protected final boolean checkSenderType(final @NotNull CommandSender sender) {
        switch (this.senderType) {
            // 指令方塊 ....
            case BLOCK_SENDER -> { return sender instanceof BlockCommandSender; }

            // 玩家
            case PLAYER_SENDER -> { return sender instanceof Player; }

            // 後台
            case COMMAND_LINE_SENDER -> { return sender instanceof ConsoleCommandSender; }

            // 任何的
            case ANY_SENDER -> { return true; }

        }
        return false;
    }

}
