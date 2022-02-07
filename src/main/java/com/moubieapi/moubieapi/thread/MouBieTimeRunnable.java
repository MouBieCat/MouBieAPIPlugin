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

package com.moubieapi.moubieapi.thread;

import com.moubieapi.api.plugin.MouBiePlugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個計時器
 * @author MouBieCat
 */
public abstract class MouBieTimeRunnable
        extends MouBieBukkitRunnable {

    private final int maxCount;

    private int nowCount;

    /**
     * 建構子
     * @param plugin 插件
     * @param period 璇還週期
     */
    public MouBieTimeRunnable(final @NotNull MouBiePlugin plugin, final long period, final int count) {
        this(plugin, 0L, period, count);
    }

    /**
     * 建構子
     * @param plugin 插件
     * @param delay  開始延遲
     * @param period 璇還週期
     */
    public MouBieTimeRunnable(final @NotNull MouBiePlugin plugin, final long delay, final long period, final int count) {
        super(plugin, delay, period);
        this.maxCount = count;
        this.nowCount = count;
    }

    @Override
    public final void run() {
        if (this.nowCount <= 0)
            this.stop();

        else {
            this.whenTimeRun();
            --nowCount;
        }
    }

    /**
     * 獲取計時器最大秒數
     * @return 最大秒數
     */
    public final int getMaxCount() {
        return this.maxCount;
    }

    /**
     * 獲取計時器目前秒數
     * @return 目前秒數
     */
    public final int getNowCount() {
        return this.nowCount;
    }

    /**
     * 當計時器被執行
     */
    protected abstract void whenTimeRun();

}
