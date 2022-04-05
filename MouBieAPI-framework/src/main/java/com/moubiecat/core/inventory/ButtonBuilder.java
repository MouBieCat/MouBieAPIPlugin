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

import com.moubiecat.api.builder.ItemNBTBuilder;
import com.moubiecat.api.inventory.button.Button;
import com.moubiecat.core.itemstack.ItemStackBuilder;
import com.moubiecat.core.nbttag.ItemStackNBTTagBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * 代表一個介面按鈕類別
 * @author MouBieCat
 */
public class ButtonBuilder
        extends ItemStackBuilder
        implements Button {

    @NotNull
    private static final String MOU_BIE_API_BUTTON_TAG = "mou_bie_api_button_tag";

    @NotNull
    private static final String BUTTON_UUID = "button_uuid_tag";

    // 按鈕UUID
    @NotNull
    protected final UUID buttonId = UUID.randomUUID();

    // 介面位置
    protected int buttonSlot;

    /**
     * 建構子
     * @param material 材質
     * @param slot 介面位置
     */
    public ButtonBuilder(final @NotNull Material material, final int slot) {
        this(material, 1, slot);
    }

    /**
     * 建構子
     * @param material 材質
     * @param amount 數量
     * @param slot 介面位置
     */
    public ButtonBuilder(final @NotNull Material material, final int amount, final int slot) {
        this(new ItemStack(material, amount), slot);
    }

    /**
     * 建構子
     * @param itemStack 物品實例
     * @param slot 介面位置
     */
    public ButtonBuilder(final @NotNull ItemStack itemStack, final int slot) {
        super(itemStack);
        this.buttonSlot = slot;
    }

    /**
     * 獲取按鈕UUID
     * @return UUID
     */
    @NotNull
    public final UUID getButtonId() {
        return this.buttonId;
    }

    /**
     * 獲取物品在介面上的位置
     * @return 位置
     */
    public final int getButtonSlot() {
        return this.buttonSlot;
    }

    /**
     * 建構函數
     * @return 對象
     */
    @Override
    @NotNull
    public ItemStack build() {
        // 寫入按鈕UUID
        final ItemNBTBuilder nbtBuilder = new ItemStackNBTTagBuilder(this.itemStack, ButtonBuilder.MOU_BIE_API_BUTTON_TAG);
        this.itemStack = nbtBuilder
                .setString(ButtonBuilder.BUTTON_UUID, this.buttonId.toString())
                .build();

        return super.build();
    }

    /**
     * 獲取按鈕UUID
     * @param itemStack 物品
     * @return UUID
     */
    @Nullable
    public static UUID getButtonId(final @Nullable ItemStack itemStack) {
        if (itemStack == null)
            return null;

        final String uuidString =
                ItemStackNBTTagBuilder.getString(itemStack, ButtonBuilder.MOU_BIE_API_BUTTON_TAG, ButtonBuilder.BUTTON_UUID);

        return !uuidString.equals("") ? UUID.fromString(uuidString) : null;
    }

}
