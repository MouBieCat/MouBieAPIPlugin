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

import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一個指令
 * @author MouBieCat
 */
@ICommand(name = "null", description = "CommandAbstract")
public interface Command
        extends CommandRunnable {

    /**
     * 獲取指令名稱
     * @return 名稱
     */
    @NotNull String getCommandName();

    /**
     * 獲取指令說明
     * @return 說明
     */
    @NotNull String getDescription();

    /**
     * 獲取可發送者類型
     * @return 發送者類型
     */
    @NotNull SenderType getSenderType();

    /**
     * 獲取運行所需權限
     * @return 權限
     */
    @Nullable Permission getPermission();

}
