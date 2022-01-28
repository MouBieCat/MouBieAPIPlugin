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

import com.moubieapi.api.commands.CommandNode;
import com.moubieapi.api.manager.NodeManager;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個指令節點管理器
 * @author MouBieCat
 */
public class CommandNodeManager
        extends ManagerAbstract<String, CommandNode>
        implements NodeManager<CommandNode> {

    /**
     * 添加資料到管理器中
     * @param key   k
     * @param value v
     */
    @Override
    public void add(final @NotNull String key, final @NotNull CommandNode value) {
        if (!this.hasKey(key))
            super.add(key, value);
    }

}
