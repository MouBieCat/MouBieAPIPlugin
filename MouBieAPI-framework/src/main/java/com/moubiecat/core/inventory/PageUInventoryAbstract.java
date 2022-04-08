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

import com.moubiecat.api.inventory.gui.InventorySize;
import com.moubiecat.api.inventory.gui.PageGUI;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個帶有頁數介面的類別
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
     * 初始化介面介面
     * @param player 玩家
     */
    @Override
    @Deprecated
    protected final void initInventory(final @NotNull Player player) {
        this.initPageInventory(player, 0);
    }

    /**
     * 初始化介面頁數介面
     * @param player 玩家
     * @param page 頁數
     */
    protected abstract void initPageInventory(final @NotNull Player player, final int page);

    /**
     * 開啟一個介面的頁數
     * @param player 玩家
     * @param page   頁數
     */
    @Override
    public final void open(final @NotNull Player player, final int page) {
        super.open(player);
        this.initPageInventory(player, page);
        this.nowPage = page;
    }

    /**
     * 獲取當前頁數
     *
     * @return 頁數
     */
    @Override
    public final int getPage() {
        return this.nowPage;
    }

    /**
     * 開啟下一頁
     *
     * @param player 玩家
     */
    @Override
    public final void nextPage(final @NotNull Player player) {
        this.open(player, ++this.nowPage);
    }

    /**
     * 開啟上一頁
     *
     * @param player 玩家
     */
    @Override
    public final void previousPage(final @NotNull Player player) {
        this.open(player, --this.nowPage);
    }

    /**
     * 將頁數重製
     */
    protected final void restPage() {
        this.nowPage = 0;
    }

}
