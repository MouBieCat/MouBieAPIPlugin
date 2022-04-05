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

package com.moubieapi.commands.args;

import com.moubiecat.Utils;
import com.moubiecat.api.commands.SenderType;
import com.moubiecat.api.plugin.MouBiePlugin;
import com.moubiecat.core.commands.SubcommandAbstract;
import com.moubieapi.MouBieCat;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * 代表插件的重讀指令
 * @author MouBieCat
 */
public final class CommandReload
        extends SubcommandAbstract {

    /**
     * 建構子
     * @param name        子指令名
     * @param permission  指令權限
     * @param type        指令發送者
     * @param description 指令說明
     */
    public CommandReload(final @NotNull String name, final @Nullable Permission permission, final @NotNull SenderType type, final @NotNull String description) {
        super(name, permission, type, description);
    }

    /**
     * 運行該節點指令
     * @param sender 發送者
     * @param args   參數
     * @return 是否成功運行
     */
    public boolean onCmd(final @NotNull CommandSender sender, final @NotNull String[] args) {

        if (args.length == 2) {

            if (Utils.reloadMouBiePlugin(args[1])) {
                sender.sendMessage(MouBieCat.PLUGIN_TITLE + "§2您成功對 §6" + args[1] + " §2插件進行了重讀！");
                return true;
            }

            sender.sendMessage(MouBieCat.PLUGIN_TITLE + "§c很抱歉，沒有找到名稱為 §6" + args[1] + " §c的插件。");
            return false;
        }

        sender.sendMessage(MouBieCat.PLUGIN_TITLE + "§c很抱歉，您所輸入的參數不足，請輸入一個插件名稱。");
        return false;
    }

    /**
     * 運行該節點指令幫助列表
     * @param sender 發送者
     * @param args   參數
     * @return 節點指令幫助列表
     */
    @NotNull
    public List<String> onTab(final @NotNull CommandSender sender, final @NotNull String[] args) {
        final List<String> list = new ArrayList<>();

        if (args.length == 2) {
            final List<MouBiePlugin> plugins = Utils.getMouBiePlugins();
            list.addAll(plugins.stream().map(MouBiePlugin::getName).toList());
        }

        return list;
    }

}
