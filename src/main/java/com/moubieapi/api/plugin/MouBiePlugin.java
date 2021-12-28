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

package com.moubieapi.api.plugin;

import com.moubieapi.api.Debugger;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個我(MouBieCat)自己所寫的插件
 * @author MouBieCat
 */
public abstract class MouBiePlugin
        extends JavaPlugin {

    // 紀錄器
    protected final Debugger debugger;

    /**
     * 建構子
     */
    public MouBiePlugin() {
        this.debugger = new Debugger(this);
    }

    /**
     * 當插件加載時調用
     */
    @Override
    public void onLoad() {
    }

    /**
     * 當插件啟動時調用
     */
    @Override
    public void onEnable() {
        this.loadFiles();
        this.loadCommands();
        this.loadListener();
    }

    /**
     * 當插件關閉時調用
     */
    @Override
    public void onDisable() {
    }

    /**
     * 當插件重讀時調用
     */
    public void onReload() {
    }

    /**
     * 插件加載檔案方法
     */
    protected void loadFiles() {
    }

    /**
     * 插件加載指令方法
     */
    protected void loadCommands() {
    }

    /**
     * 插件加載事件監聽器方法
     */
    protected void loadListener() {
    }

    /**
     * 獲取紀錄器
     * @return 紀錄器
     */
    @NotNull
    public final Debugger getDebugger() {
        return this.debugger;
    }

}
