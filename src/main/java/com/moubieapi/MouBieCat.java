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

package com.moubieapi;

import com.moubieapi.api.plugin.Register;
import com.moubieapi.listener.InventoryListener;
import com.moubieapi.moubieapi.plugin.MouBiePluginBase;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表該插件的主要類別
 * @author MouBieCat
 */
public final class MouBieCat
        extends MouBiePluginBase {

    @Register(name = "註冊插件事件", type = Register.ActionType.ACTION_ENABLE)
    public void registerListener() {
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
    }

    /**
     * 獲取當前插件實例
     * @return 插件本身
     */
    @NotNull
    public static MouBieCat getInstance() {
        return JavaPlugin.getPlugin(MouBieCat.class);
    }

}
