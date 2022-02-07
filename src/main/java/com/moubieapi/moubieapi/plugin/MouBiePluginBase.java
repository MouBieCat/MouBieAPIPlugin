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

package com.moubieapi.moubieapi.plugin;

import com.moubieapi.api.plugin.MouBiePlugin;
import com.moubieapi.api.plugin.PluginDebugger;
import com.moubieapi.api.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個基礎的沫白插件
 * @author MouBieCat
 */
public abstract class MouBiePluginBase
        extends JavaPlugin
        implements MouBiePlugin {

    // 加載器
    @NotNull
    private final PluginLoader loader = new MouBiePluginLoader(this);

    // 紀錄器
    @NotNull
    private final PluginDebugger debugger = new MouBiePluginDebugger(this);

    /**
     * 插件加載時調用
     */
    @Override
    public final void onLoad() {
        this.loader.executeLoadAction();
    }

    /**
     * 插件啟用時調用
     */
    @Override
    public final void onEnable() {
        this.loader.executeEnableAction();
    }

    /**
     * 插件關閉時調用
     */
    @Override
    public final void onDisable() {
        this.loader.executeDisableAction();
    }

    /**
     * 插件重讀時調用
     */
    public final void onReload() {
        this.loader.executeReloadAction();
    }

    /**
     * 獲取插件加載器
     * @return 加載器
     */
    @NotNull
    public final PluginLoader getLoader() {
        return this.loader;
    }

    /**
     * 獲取紀錄器
     * @return 紀錄器
     */
    @NotNull
    public final PluginDebugger getDebugger() {
        return this.debugger;
    }

}
