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

package com.cat.moubieapi.api.yaml;

import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * 有關於檔案的IO方法介面
 * @author MouBieCat
 */
public interface FileSection
        extends MemorySection {

    /**
     * 將檔案載入
     */
    void load();

    /**
     * 將特定檔案載入
     * @param file 檔案
     */
    void load(final @NotNull File file);

    /**
     * 保存至實體檔案
     */
    void save();

    /**
     * 保存至指定實體檔案
     * @param file 實體檔案
     */
    void save(final @NotNull File file);

}
