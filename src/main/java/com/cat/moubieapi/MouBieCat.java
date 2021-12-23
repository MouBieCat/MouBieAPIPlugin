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

package com.cat.moubieapi;

import com.cat.moubieapi.api.MouBieAPI;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表該插件的主類
 * @author MouBieCat
 */
public final class MouBieCat
        extends JavaPlugin {

    // 插件API
    private final MouBieAPI mouBieAPI;

    /**
     * 建構子
     */
    public MouBieCat() {
        this.mouBieAPI = new MouBieAPI();
    }

    /**
     * 獲取該插件實例
     * @return 插件本身
     */
    @NotNull
    public static MouBieCat getInstance() {
        return JavaPlugin.getPlugin(MouBieCat.class);
    }

    /**
     * 獲取插件的AIP
     * @return api
     */
    @NotNull
    public MouBieAPI getAPI() {
        return this.mouBieAPI;
    }
}
