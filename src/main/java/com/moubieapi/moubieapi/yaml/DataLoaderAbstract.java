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

package com.moubieapi.moubieapi.yaml;

import com.moubieapi.api.plugin.MouBiePlugin;
import com.moubieapi.api.yaml.DataLoader;
import org.jetbrains.annotations.NotNull;

/**
 * 有關資料載入器相關介面
 * @author MouBoeCat
 */
public abstract class DataLoaderAbstract
        extends Loader
        implements DataLoader {

    /**
     * 建構子
     * @param plugin    插件
     * @param path      檔案路徑
     * @param name      檔案
     */
    public DataLoaderAbstract(final @NotNull MouBiePlugin plugin, final @NotNull String path, final @NotNull String name) {
        super(plugin, path, name, true);
    }

    /**
     * 初始化相關動作
     */
    protected abstract void initDataLoader();

}
