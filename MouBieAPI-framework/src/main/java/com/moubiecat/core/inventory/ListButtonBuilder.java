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
import com.moubiecat.api.inventory.button.components.Content;
import com.moubiecat.api.inventory.button.components.Contents;
import com.moubiecat.api.inventory.button.event.ClickButtonEvent;
import com.moubiecat.api.inventory.button.event.ListButtonEvent;
import com.moubiecat.api.inventory.gui.GUI;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 代表一個有清單列表的按鈕建構器
 * @author MouBieCat
 */
public class ListButtonBuilder
        extends ClickButtonBuilder
        implements ListButton {

    // 按鈕樣式
    @NotNull
    protected final ListButtonStyle buttonStyle = new ListButtonStyle();

    // 內容管理器
    @NotNull
    protected final Contents contents = new ContentManager();

    /**
     * 建構子
     * @param gui       介面
     * @param slot      介面位置
     */
    public ListButtonBuilder(final @NotNull GUI gui, final int slot) {
        super(gui, new ItemStack(Material.ACACIA_BUTTON), slot);
        this.buttonClickType.add(ClickType.LEFT);
        this.buttonClickType.add(ClickType.RIGHT);
    }

    /**
     * 選取下一個項目
     * @param event 點擊事件
     */
    protected final void nextContent(final @NotNull ClickButtonEvent event) {
        this.contents.nextContent();
        // 調用選項改變事件
        this.onSelectChange(
                new ListButtonEvent(
                        event.getGUI(), event.getPlayer(), (ListButton) event.getButton(), event.getClickType()
                ));
    }

    /**
     * 選取上一個項目
     * @param event 點擊事件
     */
    protected final void previousContent(final @NotNull ClickButtonEvent event) {
        this.contents.previousContent();
        // 調用選項改變事件
        this.onSelectChange(
                new ListButtonEvent(
                        event.getGUI(), event.getPlayer(), (ListButton) event.getButton(), event.getClickType()
                ));
    }

    /**
     * 當被點擊時調用
     * @param event 事件
     */
    @Override
    protected final void onClick(final @NotNull ClickButtonEvent event) {
        switch (event.getClickType()) {
            case LEFT -> this.nextContent(event);
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

        for (final Content content : this.contents.getContents()) {
            lore.add(this.buttonStyle.replaceStyle(content));

            if (content.isSelected())
                this.type(content.getIcon());
        }

        this.lore(lore);
        return super.build();
    }

    /**
     * 獲取清單內容管理器
     * @return 內容管理器
     */
    @NotNull
    public final Contents getButtonContents() {
        return this.contents;
    }

    /**
     * 代表清單按鈕樣式
     * @author MouBieCat
     */
    protected static class ListButtonStyle {

        protected static final String CONTENT_REPLACE_STRING = "{content}";

        // 選取項目顯示樣式
        @NotNull
        public String selectItemDisplayStyle = " §f> {content}§r";

        // 未取項目顯示樣式
        @NotNull
        public String uncheckedItemDisplayStyle = " §8> {content}§r";

        /**
         * 轉換選取樣式
         * @param content 內容
         * @return 樣式
         */
        public String replaceStyle(final @NotNull Content content) {
            final String msg = content.toString();

            return content.isSelected() ?
                    this.selectItemDisplayStyle.replace(ListButtonStyle.CONTENT_REPLACE_STRING, msg) :
                    this.uncheckedItemDisplayStyle.replace(ListButtonStyle.CONTENT_REPLACE_STRING, msg);
        }
    }

}
