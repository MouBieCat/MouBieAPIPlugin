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

package com.moubiecat.moubieapi.yaml.data;

import com.moubiecat.api.plugin.MouBiePlugin;
import com.moubiecat.api.yaml.PlayerLoader;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個玩家的資料基礎載入器
 * @author MouBieCat
 */
public abstract class PlayerDataLoaderAbstract<P extends OfflinePlayer>
        extends DataLoaderAbstract
        implements PlayerLoader<P> {

    // 玩家
    @NotNull
    protected final P owner;

    /**
     * 建構子
     * @param plugin    插件
     * @param path      檔案路徑
     * @param player    玩家
     */
    public PlayerDataLoaderAbstract(final @NotNull MouBiePlugin plugin, final @NotNull String path, final @NotNull P player) {
        super(plugin, path, player.getUniqueId() + ".yml");
        this.owner = player;
    }

    /**
     * 獲取該資料載入器的玩家
     * @return 玩家
     */
    @NotNull
    public final P getPlayer() {
        return this.owner;
    }

}
