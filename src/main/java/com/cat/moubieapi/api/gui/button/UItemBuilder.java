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

import com.cat.moubieapi.api.itemstack.ItemBuilder;
import com.cat.moubieapi.moubie.gui.UItemStackBuilder;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個介面上的物品介面
 * @author MouBieCat
 */
public interface UItemBuilder
        extends ItemBuilder, Button {

    /**
     * 設定該物品是否可以被移動
     * @param canMove 是否可以
     * @return 當前的建構器
     */
    @NotNull UItemBuilder setCanMove(final boolean canMove);

    /**
     * 設定點擊的方法
     * @param clickType 點擊方法
     * @return 當前的建構器
     */
    @NotNull UItemBuilder setClickType(final @NotNull UItemStackBuilder.ClickType clickType);

    /**
     * 設定物品在介面上的位置
     * @param slotId 位置
     * @return 當前的建構器
     */
    @NotNull UItemBuilder setSlotId(final int slotId);

}
