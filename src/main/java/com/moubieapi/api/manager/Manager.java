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

package com.moubieapi.api.manager;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;

/**
 * 代表一個基礎的管理器介面
 * @author MouBieCat
 */
public interface Manager<K, V> {

    /**
     * 添加資料到管理器中
     * @param key k
     * @param value v
     */
    void add(@NotNull K key, @NotNull V value);

    /**
     * 從管理器中刪除資料
     * @param key k
     */
    void remove(@NotNull K key);

    /**
     * 從管理器中獲取資料
     * @param key k
     * @return v
     */
    @Nullable V get(@NotNull K key);

    /**
     * 檢查該管理器中是否有資料
     * @param key k
     * @return v
     */
    boolean hasKey(@NotNull K key);

    /**
     * 獲取管理器中所有的 value
     * @return 集合
     */
    @NotNull Collection<V> getValues();

    /**
     * 複製一份管理器
     * @return 複製管理器
     */
    @NotNull Map<K, V> copyManager();

}
