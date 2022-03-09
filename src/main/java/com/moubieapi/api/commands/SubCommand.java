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

package com.moubieapi.api.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一個子指令
 * @author MouBieCat
 */
public interface SubCommand
        extends CommandExecutable {

    /**
     * 獲取指令名稱
     * @return 名稱
     */
    @NotNull String getName();

    /**
     * 獲取指令權限
     * @return 權限
     */
    @Nullable Permission getPermission();

    /**
     * 獲取指令發送者
     * @return 發送者
     */
    @NotNull SenderType getSenderType();

    /**
     * 獲取指令說明
     * @return 說明
     */
    @NotNull String getDescription();

    /**
     * 檢查指令是否可以被該發送者運行
     * @param sender 發送者
     * @param args 指令參數
     * @return 是否可以運行
     */
    boolean checkCommand(@NotNull CommandSender sender, @NotNull String[] args);

    /**
     * 檢查指令幫助訊息是否可以被使用者查看
     * @param sender 發送者
     * @param args 指令參數
     * @return 是否可以查看
     */
    boolean checkTab(@NotNull CommandSender sender, @NotNull String[] args);

}
