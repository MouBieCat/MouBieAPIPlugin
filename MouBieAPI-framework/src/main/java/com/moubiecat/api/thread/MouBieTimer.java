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

/**
 * 代表一個計時器
 * @author MouBieCat
 */
public interface MouBieTimer
        extends MouBieRunnable {

    /**
     * 獲取計時器最大秒數
     * @return 最大秒數
     */
    int getMaxCount();

    /**
     * 獲取計時器目前秒數
     * @return 目前秒數
     */
    int getNowCount();

}
