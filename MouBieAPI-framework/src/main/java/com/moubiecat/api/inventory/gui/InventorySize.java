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

package com.moubiecat.api.inventory.gui;

/**
 * 代表一個介面大小的枚舉
 * @author MouBieCat
 */
public enum InventorySize {

    ONE(9),     // 一行
    TWO(18),    // 兩行
    THREE(27),  // 三行
    FOUR(36),   // 四行
    FIVE(45),   // 五行
    SIX(54);    // 六行

    // 大小
    private final int size;

    /**
     * 建構子
     * @param size 大小
     */
    InventorySize(int size) {
        this.size = size;
    }

    /**
     * 獲取大小
     * @return 大小
     */
    public final int getSize() {
        return this.size;
    }

    /**
     * 轉換成字串類型
     * @return 字串
     */
    @Override
    public final String toString() {
        return "InventorySize{" + "size=" + size + '}';
    }

}
