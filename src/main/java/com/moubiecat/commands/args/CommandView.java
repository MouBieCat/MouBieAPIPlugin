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

package com.moubiecat.commands.args;

import com.moubiecat.api.commands.ICommand;
import com.moubiecat.api.commands.SenderType;
import com.moubiecat.api.inventory.gui.GUI;
import com.moubiecat.api.inventory.gui.PageGUI;
import com.moubiecat.inventory.ViewPluginInventory;
import com.moubiecat.moubieapi.commands.CommandAbstract;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@ICommand(name = "view", description = "查看當前由 MouBieCat 旗下所開發所有插件介面。")
public final class CommandView
        extends CommandAbstract {
    /**
     * 建構子
     */
    public CommandView() {
        super("view", "查看當前由 MouBieCat 旗下所開發所有插件介面。", SenderType.PLAYER_SENDER, new Permission("MouBieAPI.view"));
    }

    /**
     * 運行命令
     * @param sender 發送者
     * @param args   參數
     * @return 是否成功運行
     */
    @Override
    public boolean runCommand(final @NotNull CommandSender sender, final @NotNull String[] args) {
        if (!this.hasPermission(sender) || !this.checkSenderType(sender))
            return false;

        final Player player = (Player) sender;
        final PageGUI viewPluginGUI = new ViewPluginInventory();
        viewPluginGUI.open(player, 0);

        return false;
    }

    /**
     * 命令說明列
     * @param sender 發送者
     * @param args   參數
     * @return 參數集合
     */
    @Override
    @NotNull
    public List<String> runTabComplete(final @NotNull CommandSender sender, final @NotNull String[] args) {
        return new ArrayList<>();
    }

}
