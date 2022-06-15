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

package com.moubiecat.core.inventory;

import com.moubiecat.api.inventory.button.components.Content;
import com.moubiecat.api.inventory.button.components.Contents;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * 代表一個容器管理器實作類
 * @author MouBieCat
 */
public final class ContentManager
        implements Contents {

    // 內容清單
    @NotNull
    private final List<Content> contents = new LinkedList<>();

    // 當前選取內容ID
    private int selectedItemIndex = -1;

    /**
     * 添加一個內容至清單
     * @param contents 內容
     */
    public void addContents(final @NotNull Content... contents) {
        this.contents.addAll(Arrays.asList(contents));
    }

    /**
     * 選取下一個項目
     */
    public void nextContent() {
        try {
            // 如果獲取索引異常，則將索引歸零
            this.contents.get(this.selectedItemIndex++).setSelected(false);

        } catch (final IndexOutOfBoundsException e) {
            // 歸零索引
            this.selectedItemIndex = 0;

        } finally {
            // 如果索引超出大小，則將索引歸零
            if (this.selectedItemIndex >= this.contents.size())
                this.selectedItemIndex = 0;

            // 將當前指向的索引設定選擇中
            this.contents.get(this.selectedItemIndex).setSelected(true);
        }
    }

    /**
     * 選取上一個項目
     */
    public void previousContent() {
        try {
            // 如果獲取索引異常，則將索引指向最後一個
            this.contents.get(this.selectedItemIndex--).setSelected(false);

        } catch (final IndexOutOfBoundsException e) {
            this.selectedItemIndex = this.contents.size() - 1;

        } finally {
            // 如果索引小於零，則將索引指向最後一個
            if (this.selectedItemIndex < 0)
                this.selectedItemIndex = this.contents.size() - 1;

            // 將當前指向的索引設定選擇中
            this.contents.get(this.selectedItemIndex).setSelected(true);
        }
    }

    /**
     * 獲取當前選取的項目ID
     * @return ID
     */
    public int getSelectedIndex() {
        return this.selectedItemIndex;
    }

    /**
     * 獲取當前選取的項目
     * @return 項目
     */
    @Nullable
    public Content getSelected() {
        try {
            return this.contents.get(this.selectedItemIndex);
        } catch (final IndexOutOfBoundsException e) { return null; }
    }

    /**
     * 獲取一個指定的內容
     * @param index 位置
     * @return 內容
     */
    @Nullable
    public Content getContent(final int index) {
        return this.contents.get(index);
    }

    /**
     * 獲取所有容器中的內容
     * @return 內容清單
     */
    @NotNull
    public Collection<Content> getContents() {
        return new ArrayList<>(this.contents);
    }

}
