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
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 代表一個有清單列表的按鈕建構器
 * @author MouBieCat
 */
public abstract class ListButtonBuilder
        extends ClickButtonBuilder
        implements ListButton {

    // 內容集合
    @NotNull
    protected List<String> contents = new LinkedList<>();

    // 選取內容ID
    private int selectItem = 0;

    // 按鈕樣式
    @NotNull
    protected final ListButtonStyle buttonStyle = new ListButtonStyle();

    /**
     * 建構子
     * @param material 材質
     * @param slot     介面位置
     */
    public ListButtonBuilder(final @NotNull Material material, final int slot) {
        this(material, 1, slot);
    }

    /**
     * 建構子
     * @param material 材質
     * @param amount   數量
     * @param slot     介面位置
     */
    public ListButtonBuilder(final @NotNull Material material, final int amount, final int slot) {
        this(new ItemStack(material, amount), slot);
    }

    /**
     * 建構子
     * @param itemStack 物品實例
     * @param slot      介面位置
     */
    public ListButtonBuilder(final @NotNull ItemStack itemStack, final int slot) {
        super(itemStack, slot);
    }

    /**
     * 初始化按鈕配置
     */
    @Override
    protected void initButton() {
        this.buttonClickType.add(ClickType.LEFT);
        this.buttonClickType.add(ClickType.RIGHT);
    }

    /**
     * 選取下一個項目
     */
    protected final void nextContents(final @NotNull ClickButtonEvent event) {
        // 如果選取項已經到最大
        if (this.selectItem >= this.contents.size() - 1)
            // 將選取項拉回第一項
            this.selectItem = 0;
        else
            // 其他則正常操作
            this.selectItem++;

        this.changeContent0(event);
    }

    /**
     * 選取上一個項目
     */
    protected final void previousContent(final @NotNull ClickButtonEvent event) {
        // 如果選取項已經到最底
        if (this.selectItem <= 0)
            // 則將選取向拉到最後一個
            this.selectItem = this.contents.size() - 1;

        else
            // 其他則正常操作
            this.selectItem--;

        this.changeContent0(event);
    }

    /**
     * 改變內容時
     * @param event 事件
     */
    private void changeContent0(final @NotNull ClickButtonEvent event) {
        this.onSelectChange(new ListButtonEvent(event, this.selectItem));
    }

    /**
     * 獲取當前選取項目ID
     * @return ID
     */
    public final int getSelectIndex() {
        return this.selectItem;
    }

    /**
     * 獲取當前選取的項目
     * @return 項目
     */
    @NotNull
    public final String getSelectContent() {
        return this.getContent(this.selectItem);
    }

    /**
     * 獲取一個指定的內容
     * @param index 位置
     * @return 內容
     */
    @NotNull
    public final String getContent(final int index) {
        if (index >= this.contents.size())
            return "";

        return this.contents.get(index);
    }

    /**
     * 獲取所有內容
     * @return 內容
     */
    @NotNull
    public final List<String> getContents() {
        return this.contents;
    }

    /**
     * 當被點級時調用
     * @param event 事件
     */
    @Override
    protected void onClick(final @NotNull ClickButtonEvent event) {
        switch (event.getClickTypes()) {
            case LEFT -> this.nextContents(event);
            case RIGHT -> this.previousContent(event);
        }
    }

    /**
     * 當選取項目改變時調用
     * @param event 事件
     */
    protected void onSelectChange(final @NotNull ListButtonEvent event) {
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
        for (int i = 0; i < this.contents.size(); i++)
            lore.add(this.buttonStyle.replaceStyle(
                    this.getContent(i),
                    i == this.selectItem)
            );


        this.lore(lore);
        return super.build();
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
