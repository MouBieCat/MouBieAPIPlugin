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

package com.moubiecat.api.thread;

import com.moubiecat.api.plugin.MouBiePlugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個沫白自訂程序
 * @author MouBieCat
 */
public interface MouBieRunnable
        extends Runnable {

    /**
     * 獲取該程序的插件
     * @return 插件
     */
    @NotNull
    MouBiePlugin getPlugin();

    /**
     * 設定程序開始時延遲週期
     * @param delay 新延遲
     * @return 該實例
     */
    @NotNull MouBieRunnable setDelay(long delay);

    /**
     * 設定程序環延遲週期
     * @param period 新週期
     * @return 該實例
     */
    @NotNull MouBieRunnable setPeriod(long period);

    /**
     * 獲取程序開始時延遲時間
     * @return 延遲週期
     */
    long getDelay();

    /**
     * 獲取程序循環延遲週期
     * @return 延遲週期
     */
    long getPeriod();

    /**
     * 使程序開始
     */
    void start();

    /**
     * 使程序關閉
     */
    void stop();

    /**
     * 使程序重新開始
     */
    void restart();

}
