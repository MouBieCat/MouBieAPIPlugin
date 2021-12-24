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

package com.moubiecat.moubieapi.manager;

import com.moubiecat.api.manager.DataManager;
import com.moubiecat.api.yaml.DataLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一個資料管理器基礎類別
 * @param <P> 任何類型
 * @param <D> 資料類型
 * @author MouBieCat
 */
public abstract class DataManagerAbstract<P, D extends DataLoader>
        extends ManagerAbstract<P, D>
        implements DataManager<P, D> {

    /**
     * 添加資料到管理器中
     * @param key   k
     * @param value v
     */
    @Override
    public void add(final @NotNull P key, final @NotNull D value) {
        final D data = this.get(key);
        if (data != null)
            this.remove(key);

        super.add(key, value);
    }

    /**
     * 從管理器中刪除資料
     * @param key k
     */
    @Override
    public void remove(final @NotNull P key) {
        final D data = this.get(key);
        if (data != null)
            data.saveFile();

        super.remove(key);
    }

    /**
     * 從管理器中獲取資料
     * @param key k
     * @return v
     */
    @Override
    @Nullable
    public D get(final @NotNull P key) {
        return super.get(key);
    }

}
