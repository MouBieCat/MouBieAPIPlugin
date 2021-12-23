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

package com.cat.moubieapi.moubie.yaml;

import com.cat.moubieapi.api.Debugger;
import com.cat.moubieapi.api.yaml.MemorySection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * 一個載入檔案最底層的工作類
 * @author MouBieCat
 */
public abstract class MemoryModuleAbstract
        implements MemorySection {

    // 插件
    @NotNull
    protected Plugin plugin;

    // 檔案
    protected File file;

    // YAML
    protected YamlConfiguration configuration = new YamlConfiguration();

    /**
     * 建構子
     * @param path 路徑
     */
    public MemoryModuleAbstract(final @NotNull Plugin plugin, final @NotNull String path) {
        this.plugin = plugin;

        final File pathFileObj = new File(plugin.getDataFolder(), path);
        if (!this.createPath(pathFileObj))
            Debugger.warning(plugin, "§c用於存放檔案路徑創建失敗，這是一個錯誤訊息。");
    }

    /**
     * 創建路徑
     * @param path 檔案路徑
     * @return 是否成功創建
     */
    protected final boolean createPath(final @NotNull File path) {
        if(!path.exists())
            return path.mkdirs();

        return true;
    }

    /**
     * 獲取檔案實例
     * @return 檔案
     */
    @NotNull
    public final File getFile() {
        return this.file;
    }

    /**
     * 獲取YAML實例
     * @return YAML
     */
    @NotNull
    public final YamlConfiguration getConfiguration() {
        return this.configuration;
    }

    /**
     * 獲取檔案的插件
     * @return 插件
     */
    @NotNull
    public final Plugin getPlugin() {
        return this.plugin;
    }
}
