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

package com.moubieapi.api.commands;

import com.moubieapi.moubieapi.commands.NodeTransfer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一個基本節點
 * @author MouBieCat
 */
public interface Node<T extends Node<?>> {

    /**
     * 獲取當前節點列數
     * @return 列數
     */
    int getNodeId();

    /**
     * 獲取節點名稱
     * @return 節點名稱
     */
    @NotNull String getNodeName();

    /**
     * 獲取下一格節點
     * @param transfer 節點查找傳遞物件
     * @return 下一個節點
     */
    @Nullable T next(@NotNull NodeTransfer transfer);

}
