/**
 * LICENSE
 * MouBieAPI
 * -------------
 * Copyright (C) 2022 MouBieCat(MouBie_Yuki)
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

package com.moubiecat.api.inventory.button.components;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

/**
 * 代表容器中的內容項目
 * @author MouBieCat
 */
public class Content {

    // 顯示圖樣
    @NotNull
    protected final Material icon;

    // 顯示訊息
    @NotNull
    protected final String message;

    // 是否被選擇中
    protected boolean isSelected = false;

    /**
     * 建構子
     * @param icon           圖示
     * @param message        內容訊息
     */
    public Content(final @NotNull Material icon, final @NotNull String message) {
        this.icon = icon;
        this.message = message;
    }

    /**
     * 獲取顯示圖標
     * @return 圖標
     */
    @NotNull
    public final Material getIcon() {
        return this.icon;
    }

    /**
     * 獲取顯示訊息
     * @return 訊息
     */
    @NotNull
    public final String getDisplayMessage() {
        return this.message;
    }

    /**
     * 獲取當前選擇狀態
     * @return 狀態
     */
    public final boolean isSelected() {
        return this.isSelected;
    }

    /**
     * 設定選擇狀態
     * @param state 狀態
     */
    public final void setSelected(final boolean state) {
        this.isSelected = state;
    }

    /**
     * 轉成字串型別
     * @return 訊息
     */
    @Override
    @NotNull
    public String toString() {
        return this.message;
    }

}
