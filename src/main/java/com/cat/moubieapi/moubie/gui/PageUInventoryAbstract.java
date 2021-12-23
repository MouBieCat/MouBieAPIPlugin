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

package com.cat.moubieapi.moubie.gui;

import com.cat.moubieapi.api.gui.ui.PageGUI;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個有多頁數的介面建構器
 * @author MouBieCat
 */
public abstract class PageUInventoryAbstract
        extends UInventoryAbstract
        implements PageGUI {

    // 當前頁數 (預設=0)
    private int nowPage = 0;

    /**
     * 建構子
     * @param title 介面標題
     * @param size  介面大小
     */
    public PageUInventoryAbstract(final @NotNull String title, final @NotNull InventorySize size) {
        super(title, size);
    }

    /**
     * 開啟一個特定頁數
     * @param player 玩家
     * @param page   頁數
     */
    public final void open(final @NotNull Player player, final int page) {
        this.initPageInventory(player, page);
        super.open(player);
    }

    /**
     * 獲取當前頁數
     * @return 頁數
     */
    public final int getPage() {
        return this.nowPage;
    }

    /**
     * 將頁數翻回初始頁
     */
    protected final void resetPage() {
        this.nowPage = 0;
    }

    /**
     * 翻至下一頁
     * @param player 玩家
     */
    public final void nextPage(final @NotNull Player player) {
        this.nowPage += 1;
        this.open(player, this.nowPage);
    }

    /**
     * 翻至上一頁
     * @param player 玩家
     */
    public final void previousPage(final @NotNull Player player) {
        this.nowPage -= 1;
        this.open(player, this.nowPage);
    }

    /**
     * 初始化介面
     * @param player 玩家
     */
    @Override
    @Deprecated
    protected final void initInventory(final @NotNull Player player) {}

    /**
     * 初始化介面
     * @param player 玩家
     * @param page 頁數
     */
    protected abstract void initPageInventory(final @NotNull Player player, final int page);

}
