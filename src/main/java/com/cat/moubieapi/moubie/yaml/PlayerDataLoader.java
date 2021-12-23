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

package com.cat.moubieapi.moubie.yaml;

import com.cat.moubieapi.api.yaml.PlayerDataFile;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個最基礎的玩家紀錄檔案載入器
 * @author MouBieCat
 */
public class PlayerDataLoader
        extends DataLoaderAbstract
        implements PlayerDataFile {

    // 資料擁有人
    protected final Player player;

    /**
     * 建構子
     * @param plugin 插件
     * @param path 檔案路徑
     * @param player 資料擁有人
     */
    public PlayerDataLoader(final @NotNull Plugin plugin, final @NotNull String path, final @NotNull Player player) {
        super(plugin, path, player.getUniqueId() + ".yml");
        this.player = player;
        this.initPlayerData();
    }

    /**
     * 獲取資料擁有者
     * @return 玩家(擁有者)
     */
    @NotNull
    public final Player getPlayer() {
        return this.player;
    }

    /**
     * 初始化
     */
    protected void initPlayerData() {
        this.configuration.set("uuid", player.getUniqueId().toString());
        this.configuration.set("name", player.getName());
        this.save();
    }

}
