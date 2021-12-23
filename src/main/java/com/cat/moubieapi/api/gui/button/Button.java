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

package com.cat.moubieapi.api.gui.button;

import com.cat.moubieapi.moubie.gui.UItemStackBuilder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一個介面物品
 * @author MouBieCat
 */
public interface Button {

    /**
     * 解析一個物品是否可以被使用者移動
     * @param itemStack 物品
     * @return 是否可被移動
     */
    static boolean getItemStackCanMove(final @NotNull ItemStack itemStack) {
        return UItemStackBuilder.getItemStackCanMove(itemStack);
    }

    /**
     * 解析一個物品的點擊操作類型
     * @param itemStack 物品
     * @return 類型
     */
    @Nullable
    static UItemStackBuilder.ClickType getItemStackClickType(final @NotNull ItemStack itemStack) {
        return UItemStackBuilder.getItemStackClickType(itemStack);
    }

    /**
     * 獲取物品在介面上的位置
     * @return 位置
     */
    int getSlotId();

    /**
     * 獲取該物品是否可以被移動
     * @return 類型
     */
    boolean getButtonCanMove();

    /**
     * 獲取點擊的方法
     * @return 點擊方法
     */
    @NotNull UItemStackBuilder.ClickType getClickType();

    /**
     * 將物品建置出來
     * @return 物品
     */
    @NotNull ItemStack build();

}
