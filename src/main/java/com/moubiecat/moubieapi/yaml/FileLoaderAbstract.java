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

package com.moubiecat.moubieapi.yaml;

import com.moubiecat.api.plugin.MouBiePlugin;
import com.moubiecat.api.yaml.FileSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

/**
 * 載入黨案所需的IO處理類別
 * @author MouBieCat
 */
public abstract class FileLoaderAbstract
        extends MemoryLoaderAbstract
        implements FileSection {

    /**
     * 建構子
     * @param plugin 插件
     * @param path 檔案路徑
     * @param name 檔案
     * @param isNewFile 是否新創建
     */
    public FileLoaderAbstract(final @NotNull MouBiePlugin plugin, final @NotNull String path, final @NotNull String name, final boolean isNewFile) {
        super(plugin, path);

        final File pathObj = new File(this.getPlugin().getDataFolder(), path);
        final File fileObj = new File(pathObj, name);

        if (!fileObj.exists()) {
            if (isNewFile) {
                if (!this.createFile(fileObj))
                    this.getPlugin().getDebugger().warning("§c創建一個新的檔案配置失敗，這是一個錯誤訊息。");
            }
            else
                this.getPlugin().saveResource(path + name, false);
        }

        this.file = fileObj;
    }

    /**
     * 將檔案載入
     */
    public final void load() {
        this.load(this.file);
    }

    /**
     * 將特定檔案載入
     * @param file 檔案
     */
    public final void load(final @NotNull File file) {
        this.file = file;
        this.configuration = YamlConfiguration.loadConfiguration(file);
    }

    /**
     * 保存至實體檔案
     */
    public final void save() {
        this.save(this.file);
    }

    /**
     * 保存至指定實體檔案
     * @param file 實體檔案
     */
    public final void save(final @NotNull File file) {
        try {
            this.file = file;
            this.configuration.save(file);
        } catch (final IOException e) {
            e.printStackTrace();
            this.getPlugin().getDebugger().warning("§c嘗試將檔案保存至實體位置失敗，這是一個錯誤訊息。");
        }
    }

    /**
     * 創建檔案方法
     * @param file 檔案
     * @return 是否成功創建
     */
    protected final boolean createFile(final @NotNull File file) {
        if (!file.exists()) {
            try {
                return file.createNewFile();
            } catch (final IOException ignored) { return false; }
        }
        return true;
    }

}
