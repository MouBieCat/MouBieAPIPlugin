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

package com.moubieapi.moubieapi.manager;

import com.moubieapi.api.manager.ThreadManager;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

/**
 * 用於紀錄相關線程的管理器介面
 * @param <P> 玩家類型
 * @param <T> 任何類型
 * @author MouBieCat
 */
public abstract class ThreadManagerAbstract<P, T extends BukkitRunnable>
        extends ManagerAbstract<P, T>
        implements ThreadManager<P, T> {

    /**
     * 添加資料到管理器中
     * @param key   k
     * @param value v
     */
    @Override
    public final void add(final @NotNull P key, final @NotNull T value) {
        if (this.hasKey(key))
            this.remove(key);

        super.add(key, value);
    }

    /**
     * 從管理器中刪除資料
     * @param key k
     */
    @Override
    public final void remove(final @NotNull P key) {
        final T thread = this.get(key);
        if (thread != null)
            thread.cancel();

        super.remove(key);
    }

}
