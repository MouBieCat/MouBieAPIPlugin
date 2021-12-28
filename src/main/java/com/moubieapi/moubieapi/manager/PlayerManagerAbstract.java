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

import com.moubieapi.api.manager.PlayerManager;
import com.moubieapi.api.yaml.PlayerLoader;
import org.bukkit.entity.Player;

/**
 * 用於紀錄相關資料的任務資料管理器介面(不包含下線玩家)
 * @param <D> 資料類型
 * @author MouBieCat
 */
public abstract class PlayerManagerAbstract<D extends PlayerLoader<Player>>
        extends OfflinePlayerManagerAbstract<Player, D>
        implements PlayerManager<D> {
}
