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

package com.moubiecat.core.inventory;

import com.moubiecat.api.inventory.button.Clickable;
import com.moubiecat.api.inventory.button.ClickButtonEvent;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個可點擊的按鈕建構器
 * @author MouBieCat
 */
public abstract class ClickButtonBuilder
        extends ButtonBuilder
        implements Clickable {

    /**
     * 建構子
     * @param material 材質
     * @param slot     介面位置
     */
    public ClickButtonBuilder(final @NotNull Material material, final int slot) {
        super(material, slot);
    }

    /**
     * 建構子
     * @param material 材質
     * @param amount   數量
     * @param slot     介面位置
     */
    public ClickButtonBuilder(final @NotNull Material material, final int amount, final int slot) {
        super(material, amount, slot);
    }

    /**
     * 建構子
     * @param itemStack 物品實例
     * @param slot      介面位置
     */
    public ClickButtonBuilder(final @NotNull ItemStack itemStack, final int slot) {
        super(itemStack, slot);
    }

    /**
     * 當被點級時調用
     * @param event 事件
     */
    protected abstract void onClick(final @NotNull ClickButtonEvent event);

    /**
     * 執行監聽事件
     * @param event 事件
     */
    public final void executeListener(final @NotNull ClickButtonEvent event) {
        if (this.clickTypes.contains(event.getClickTypes()))
            this.onClick(event);
    }

}
