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

import com.moubieapi.api.commands.Node;
import com.moubieapi.api.manager.NodeManager;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個節點管理器
 * @param <N> 節點類型
 * @author MouBieCat
 */
public abstract class NodeManagerAbstract<N extends Node<?>>
        extends ManagerAbstract<String, N>
        implements NodeManager<N> {

    @Override
    public void add(final @NotNull String key, final @NotNull N value) {
        if (!this.hasKey(key))
            super.add(key, value);
    }

}
