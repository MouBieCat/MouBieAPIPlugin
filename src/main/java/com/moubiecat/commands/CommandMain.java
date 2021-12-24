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

package com.moubiecat.commands;

import com.moubiecat.api.manager.CommandManager;
import com.moubiecat.commands.args.CommandView;
import com.moubiecat.moubieapi.manager.CommandManagerAbstract;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 代表該插件的主命令類別
 * @author MouBieCat
 */
public final class CommandMain
        extends CommandManagerAbstract
        implements CommandManager {

    /**
     * 建構子
     */
    public CommandMain() {
        this.add("view", new CommandView());
    }

    @Override
    public boolean onCommand(final @NotNull CommandSender sender, final @NotNull Command cmd, final @NotNull String cmdStr, final @NotNull String[] args) {
        if (args.length == 1) {
            final com.moubiecat.api.commands.Command command = this.get(args[0]);
            if (command != null)
                return command.runCommand(sender, args);
        }

        return false;
    }

    @NotNull
    @Override
    public List<String> onTabComplete(final @NotNull CommandSender sender, final @NotNull Command cmd, final @NotNull String cmdStr, final @NotNull String[] args) {
        if (args.length == 1) {
            final List<String> tabStrings = new ArrayList<>();
            final Collection<com.moubiecat.api.commands.Command> commands = this.getValues();

            for (final com.moubiecat.api.commands.Command command : commands)
                tabStrings.add(command.getCommandName());

            return tabStrings;

        } else if (args.length >= 2) {
            final com.moubiecat.api.commands.Command command = this.get(args[0]);
            if (command != null)
                return command.runTabComplete(sender, args);
        }

        return new ArrayList<>();
    }

}
