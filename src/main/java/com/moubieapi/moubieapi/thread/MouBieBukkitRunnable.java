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
import com.moubieapi.api.thread.MouBieRunnable;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個沫白自訂程序
 * @author MouBieCat
 */
public abstract class MouBieBukkitRunnable
        extends BukkitRunnable
        implements MouBieRunnable {

    // 插件
    @NotNull
    private final MouBiePlugin plugin;

    // 開始延遲
    private long delay;

    // 璇還週期
    private long period;

    /**
     * 建構子
     * @param plugin 插件
     * @param period 璇還週期
     */
    public MouBieBukkitRunnable(final @NotNull MouBiePlugin plugin, final long period) {
        this(plugin, 0L, period);
    }

    /**
     * 建構子
     * @param plugin 插件
     * @param delay 開始延遲
     * @param period 璇還週期
     */
    public MouBieBukkitRunnable(final @NotNull MouBiePlugin plugin, final long delay, final long period) {
        this.plugin = plugin;
        this.delay = delay;
        this.period = period;
        this.start();
    }

    /**
     * 使程序開始
     */
    @Override
    public final void start() {
        this.whenTimeStart();
        this.runTaskTimer(this.plugin, this.delay, this.period);
    }

    /**
     * 使程序關閉
     */
    @Override
    public final void stop() {
        this.whenTimeStops();
        this.cancel();
    }

    /**
     * 使程序重新開始
     */
    @Override
    public final void restart() {
        this.cancel();
        this.whenTimeRestart();
        this.runTaskTimer(this.plugin, this.delay, this.period);
    }

    /**
     * 獲取該程序的插件
     * @return 插件
     */
    @NotNull
    public final MouBiePlugin getPlugin() {
        return this.plugin;
    }

    /**
     * 獲取程序開始時延遲時間
     *
     * @return 延遲週期
     */
    public final long getDelay() {
        return this.delay;
    }

    /**
     * 獲取程序循環延遲週期
     *
     * @return 延遲週期
     */
    public final long getPeriod() {
        return this.period;
    }

    /**
     * 設定程序開始時延遲週期
     * @param delay 新延遲
     * @return 該實例
     */
    public final @NotNull MouBieRunnable setDelay(final long delay) {
        this.delay = delay;
        return this;
    }

    /**
     * 設定程序環延遲週期
     * @param period 新週期
     * @return 該實例
     */
    public final @NotNull MouBieRunnable setPeriod(final long period) {
        this.period = period;
        return this;
    }

    /**
     * 計時器被取消 (強制性)
     */
    @Override
    public final synchronized void cancel() throws IllegalStateException {
        if (!this.isCancelled())
            super.cancel();
    }

    /**
     * 當計時器被調用
     */
    protected abstract void whenTimeStart();

    /**
     * 當計時器被關閉
     */
    protected abstract void whenTimeStops();

    /**
     * 當計時器被重新開始
     */
    protected abstract void whenTimeRestart();

}
