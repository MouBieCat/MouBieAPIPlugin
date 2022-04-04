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

package com.moubiecat.api.inventory.button;

import com.moubiecat.api.builder.Builder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * 代表一個介面上的按鈕
 * @author MouBieCat
 */
public interface Button
        extends Builder<ItemStack> {

    /**
     * 獲取按鈕UUID
     * @return UUID
     */
    @NotNull UUID getButtonId();

    /**
     * 獲取物品在介面上的位置
     * @return 位置
     */
    int getButtonSlot();

    /**
     * 獲取該物品是否可以被移動
     * @return 類型
     */
    boolean isButtonCancelEvent();

}
