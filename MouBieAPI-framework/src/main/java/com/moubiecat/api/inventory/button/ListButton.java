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

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 代表一個有清單列表的按鈕
 * @author MouBieCat
 */
public interface ListButton
        extends Clickable {

    /**
     * 獲取當前選取項目ID
     * @return ID
     */
    int getSelectIndex();

    /**
     * 獲取當前選取的項目
     * @return 項目
     */
    @NotNull String getSelectContent();

    /**
     * 獲取一個指定的內容
     * @param index 位置
     * @return 內容
     */
    @NotNull String getContent(final int index);

    /**
     * 獲取所有內容
     * @return 內容
     */
    @NotNull List<String> getContents();

}
