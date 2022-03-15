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

package com.moubiecat.api.commands;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 代表一個指令可運行介面
 * @author MouBieCat
 */
public interface CommandExecutable {

    /**
     * 運行該節點指令
     * @param sender 發送者
     * @param args 參數
     * @return 是否成功運行
     */
    boolean onCmd(@NotNull CommandSender sender, @NotNull String[] args);

    /**
     * 運行該節點指令幫助列表
     * @param sender 發送者
     * @param args 參數
     * @return 節點指令幫助列表
     */
    @NotNull List<String> onTab(@NotNull CommandSender sender, @NotNull String[] args);

}
