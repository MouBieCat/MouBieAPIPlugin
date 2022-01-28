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

package com.moubieapi.moubieapi.commands;

import org.jetbrains.annotations.NotNull;

/**
 * 代表用來傳遞節點資訊的物件
 * @author MouBieCat
 */
public final class NodeTransfer {

    // 下一個節點ID
    private final int nextNodeId;

    // 資訊長度
    private final int commandLength;

    // 查找節點名稱陣列
    private final String[] commandArgs;

    /**
     * 建構子
     * @param nextNodeId 下一個節點ID
     * @param cmdArgs 指令參數陣列
     */
    public NodeTransfer(final int nextNodeId, final @NotNull String[] cmdArgs) {
        this.nextNodeId = nextNodeId;
        this.commandLength = cmdArgs.length;
        this.commandArgs = cmdArgs;
    }

    /**
     * 獲取下一個查找的節點ID
     * @return 節點ID
     */
    public int getNextNodeId() {
        return this.nextNodeId;
    }

    /**
     * 獲取節點長度
     * @return 長度
     */
    public int getCommandLength() {
        return this.commandLength;
    }

    /**
     * 獲取節點名稱陣列
     * @return 節點名稱陣列
     */
    @NotNull
    public String[] getNodeArgs() {
        return this.commandArgs;
    }

}
