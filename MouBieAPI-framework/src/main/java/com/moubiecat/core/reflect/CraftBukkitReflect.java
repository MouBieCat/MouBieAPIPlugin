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

package com.moubiecat.core.reflect;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

/**
 * 加強針對 CraftBukkit 的反射機制
 * @author MouBieCat
 */
public class CraftBukkitReflect
        extends ReflectAbstract {

    // 獲取當前版本(用於將類用路徑做反射)
    @NotNull
    protected static final String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

    /**
     * 獲取 CraftBukkit 下的一個類
     * @param path org.bukkit.craftbukkit.version.路徑
     * @return 類
     */
    public static Class<?> getCraftBukkitClass(final @NotNull String path) {
        return getClass("org.bukkit.craftbukkit." + version + "." + path);
    }

}
