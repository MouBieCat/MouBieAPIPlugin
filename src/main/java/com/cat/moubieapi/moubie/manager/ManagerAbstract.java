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

package com.cat.moubieapi.moubie.manager;

import com.cat.moubieapi.api.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 代表一個基礎的管理器
 * @author MouBieCat
 */
public abstract class ManagerAbstract<K, V>
        implements Manager<K, V> {

    protected final Map<K, V> manager = new HashMap<>();

    /**
     * 添加資料到管理器中
     * @param key   k
     * @param value v
     */
    @Override
    public void add(final @NotNull K key, final @NotNull V value) {
        this.manager.put(key, value);
    }

    /**
     * 從管理器中刪除資料
     * @param key k
     */
    @Override
    public void remove(final @NotNull K key) {
        this.manager.remove(key);
    }

    /**
     * 從管理器中獲取資料
     * @param key k
     * @return v
     */
    @Nullable
    public V get(final @NotNull K key) {
        return this.manager.get(key);
    }

    /**
     * 檢查該管理器中是否有資料
     * @param key k
     * @return v
     */
    @Override
    public boolean hasKey(final @NotNull K key) {
        return this.manager.containsKey(key);
    }

    /**
     * 獲取管理器中所有的 value
     * @return 集合
     */
    @NotNull
    public Collection<V> getValues() {
        return this.manager.values();
    }

}
