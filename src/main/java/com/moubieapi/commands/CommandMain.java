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

import com.moubieapi.api.commands.SenderType;
import com.moubieapi.commands.args.CommandReload;
import com.moubieapi.moubieapi.commands.MainCommandAbstract;
import org.bukkit.permissions.Permission;

/**
 * 代表該插件的主命令
 * @author MouBieCat
 */
public final class CommandMain
        extends MainCommandAbstract {

    /**
     * 建構子
     */
    public CommandMain() {
        this.commandManager.add("reload", new CommandReload(
                "reload",
                new Permission("MouBieAPI.reload"),
                SenderType.ANY_SENDER,
                "用於重新讀取沫白旗下所開發的插件。")
        );
    }

}
