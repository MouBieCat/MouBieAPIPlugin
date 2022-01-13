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

import com.moubieapi.api.commands.Command;
import com.moubieapi.api.manager.CommandManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一個基礎的指令管理器
 * @author MouBieCat
 */
public abstract class CommandManagerAbstract
        extends ManagerAbstract<String, Command>
        implements CommandManager {

    /**
     * 添加資料到管理器中
     * @param key   k
     * @param value v
     */
    @Override
    public final void add(final @NotNull String key, final @NotNull Command value) {
        if (!this.hasKey(key))
            super.add(key, value);
    }

    /**
     * 從管理器中刪除資料
     * @param key k
     */
    @Override
    public final void remove(final @NotNull String key) {
        super.remove(key);
    }

    /**
     * 從管理器中獲取資料
     * @param key k
     * @return v
     */
    @Override
    @Nullable
    public final Command get(final @NotNull String key) {
        return super.get(key);
    }

}
