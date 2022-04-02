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

import com.moubiecat.api.manager.CommandManager;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個主指令
 * @author MouBieCat
 */
public interface MainCommand
        extends TabExecutor, CommandExecutable {

    /**
     * 獲取子指令管理器
     * @return 管理器
     */
    @NotNull CommandManager getSubCommandManager();

}
