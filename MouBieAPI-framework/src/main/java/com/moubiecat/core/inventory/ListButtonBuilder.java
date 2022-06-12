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

import com.moubiecat.api.inventory.button.ListButton;
import com.moubiecat.api.inventory.button.event.ClickButtonEvent;
import com.moubiecat.api.inventory.button.event.ListButtonEvent;
import com.moubiecat.api.inventory.gui.GUI;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 代表一個有清單列表的按鈕建構器
 * @param <T> 裝載內容
 * @author MouBieCat
 */
public class ListButtonBuilder<T extends ListButtonBuilder.Content>
        extends ClickButtonBuilder
        implements ListButton<T> {

    // 按鈕樣式
    @NotNull
    protected final ListButtonStyle buttonStyle = new ListButtonStyle();

    // 內容集合
    @NotNull
    protected final List<T> contents = new LinkedList<>();

    // 當前選取ID
    private int selectItemId = 0;

    /**
     * 建構子
     * @param material 材質
     * @param slot     介面位置
     */
    public ListButtonBuilder(final @NotNull GUI gui, final @NotNull Material material, final int slot) {
        this(gui, material, 1, slot);
    }

    /**
     * 建構子
     * @param material 材質
     * @param amount   數量
     * @param slot     介面位置
     */
    public ListButtonBuilder(final @NotNull GUI gui, final @NotNull Material material, final int amount, final int slot) {
        this(gui, new ItemStack(material, amount), slot);
    }

    /**
     * 建構子
     * @param itemStack 物品實例
     * @param slot      介面位置
     */
    public ListButtonBuilder(final @NotNull GUI gui, final @NotNull ItemStack itemStack, final int slot) {
        super(gui, itemStack, slot);
        this.buttonClickType.add(ClickType.LEFT);
        this.buttonClickType.add(ClickType.RIGHT);
    }

    /**
     * 選取下一個項目
     */
    protected final void nextContent(final @NotNull ClickButtonEvent event) {
        // 如果選取項已經到最大
        if (this.selectItemId >= this.contents.size() - 1)
            // 將選取項拉回第一項
            this.selectItemId = 0;
        else
            // 其他則正常操作
            this.selectItemId++;
        this.changeContent(event);
    }

    /**
     * 選取上一個項目
     */
    protected final void previousContent(final @NotNull ClickButtonEvent event) {
        // 如果選取項已經到最底
        if (this.selectItemId <= 0)
            // 則將選取向拉到最後一個
            this.selectItemId = this.contents.size() - 1;

        else
            // 其他則正常操作
            this.selectItemId--;
        this.changeContent(event);
    }

    /**
     * 改變內容事件函數
     * @param event 事件
     */
    private void changeContent(final @NotNull ClickButtonEvent event) {
        this.onSelectItemChange(new ListButtonEvent(event, this.selectItemId));
    }

    /**
     * 獲取當前選取項目ID
     * @return ID
     */
    public final int getSelectIndex() {
        return this.selectItemId;
    }

    /**
     * 獲取當前選取的項目
     * @return 項目
     */
    @NotNull
    public final T getSelectContent() {
        return this.contents.get(this.selectItemId);
    }

    /**
     * 獲取一個指定的內容
     * @param index 位置
     * @return 內容
     */
    @Nullable
    public final T getContent(final int index) {
        return this.contents.get(index);
    }

    /**
     * 獲取所有內容
     * @return 內容
     */
    @NotNull
    public final Collection<T> getContents() {
        return this.contents;
    }

    /**
     * 當被點擊時調用
     * @param event 事件
     */
    @Override
    protected final void onClick(final @NotNull ClickButtonEvent event) {
        switch (event.getClickTypes()) {
            case LEFT -> this.nextContent(event);
            case RIGHT -> this.previousContent(event);
        }
    }

    /**
     * 當選取項目改變時調用
     * @param event 事件
     */
    protected void onSelectItemChange(final @NotNull ListButtonEvent event) {
    }

    /**
     * 建構物品
     * @return 物品
     */
    @Override
    @NotNull
    public ItemStack build() {
        final List<String> lore = new ArrayList<>();

        // 添加子類配置的 Lore (如果有)
        final @Nullable ItemMeta itemMeta = this.itemStack.getItemMeta();
        if (itemMeta != null && itemMeta.getLore() != null)
            lore.addAll(itemMeta.getLore());

        // 添加選取項目內容
        for (int i = 0; i < this.contents.size(); i++) {
            final T content = this.contents.get(i);
            final boolean isSelectItem = (i == this.selectItemId);

            lore.add(this.buttonStyle.replaceStyle(content.message, isSelectItem));
            if (isSelectItem)
                this.type(content.icon);
        }

        this.lore(lore);
        return super.build();
    }

    /**
     * 代表清單內容
     *
     * @author MouBieCat
     */
    public static class Content {

        // 顯示圖樣
        @NotNull
        protected final Material icon;

        // 顯示訊息
        @NotNull
        protected final String message;

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
        public final String getDisplay() {
            return this.message;
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

    /**
     * 代表清單按鈕樣式
     * @author MouBieCat
     */
    protected static class ListButtonStyle {

        // 選取項目顯示樣式
        @NotNull
        public String selectItemDisplayStyle = " §f> {content}§r";

        // 未取項目顯示樣式
        @NotNull
        public String uncheckedItemDisplayStyle = " §8> {content}§r";

        /**
         * 轉換選取樣式
         * @param content 內容
         * @param isSelect 是否為選取項目
         * @return 樣式
         */
        public String replaceStyle(final @NotNull String content, final boolean isSelect) {
            return isSelect ?
                    this.selectItemDisplayStyle.replace("{content}", content) :
                    this.uncheckedItemDisplayStyle.replace("{content}", content);
        }

    }

}
