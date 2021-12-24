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

package com.moubiecat;

import com.moubiecat.api.MouBieAPI;
import com.moubiecat.api.MouBiePlugin;
import com.moubiecat.listener.InventoryListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 代表該插件的主要類別
 * @author MouBieCat
 */
public final class MouBieCat
        extends MouBiePlugin {

    /**
     * 當插件加載時調用
     */
    @Override
    public void onLoad() {
        // API 掛勾
        MouBieAPI.setMouBieCatPlugin(this);
        super.onLoad();
    }

    /**
     * 插件加載事件監聽器方法
     */
    @Override
    protected void loadListener() {
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
    }

    /**
     * 獲取當前插件實例
     * @return 插件本身
     */
    public static MouBieCat getInstance() {
        return JavaPlugin.getPlugin(MouBieCat.class);
    }

}
