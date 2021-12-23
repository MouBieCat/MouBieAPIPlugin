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

package com.cat.moubieapi.api;

import com.cat.moubieapi.MouBieCat;
import com.cat.moubieapi.api.manager.NMSManager;
import com.cat.moubieapi.moubie.manager.HandlerManager;
import org.jetbrains.annotations.NotNull;

/**
 * 代表該API所定義的一些方法
 * @author MouBieCat
 */
public final class MouBieAPI {

    // net.minecraft.server 經理
    @NotNull
    private final NMSManager nmsManager;

    /**
     * 建構子
     */
    public MouBieAPI() {
        nmsManager = new HandlerManager();
    }

    /**
     * 獲取net.minecraft.server 經理
     * @return nms經理
     */
    @NotNull
    public NMSManager getNmsManager() {
        return nmsManager;
    }

    /**
     * 獲取API實例
     * @return api
     */
    @NotNull
    public static MouBieAPI getAPI() {
        return MouBieCat.getInstance().getAPI();
    }

}
