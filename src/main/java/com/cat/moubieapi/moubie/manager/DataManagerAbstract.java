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

import com.cat.moubieapi.api.manager.DataManager;
import com.cat.moubieapi.api.yaml.DataFile;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個資料管理器
 * @param <K> 任何
 * @param <V> 繼承 DataFile
 * @author MouBieCat
 */
public abstract class DataManagerAbstract<K, V extends DataFile>
        extends ManagerAbstract<K, V>
        implements DataManager<K, V> {

    /**
     * 添加資料到管理器中
     * @param key   k
     * @param value v
     */
    @Override
    public void add(final @NotNull K key, final @NotNull V value) {
        if (this.hasKey(key))
            this.remove(key);

        super.add(key, value);
    }

    /**
     * 從管理器中刪除資料
     * @param key k
     */
    @Override
    public void remove(final @NotNull K key) {
        final V v = this.get(key);
        if (v != null)
            v.saveFile();

        super.remove(key);
    }

}
