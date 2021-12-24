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

package com.moubiecat.api;

import com.moubiecat.MouBieCat;
import org.jetbrains.annotations.NotNull;

/**
 * 代表該插件所定義的特殊方法
 * @author MouBieCat
 */
public final class MouBieAPI {

    // 插件本身
    private static MouBieCat MOU_BIE_CAT_PLUGIN;

    /**
     * 設定該API的插件本身 (請不要隨意調用該方法並且修改插件實例)
     * @param plugin 插件
     */
    public static void setMouBieCatPlugin(final @NotNull MouBieCat plugin) {
        MouBieAPI.MOU_BIE_CAT_PLUGIN = plugin;
    }

}
