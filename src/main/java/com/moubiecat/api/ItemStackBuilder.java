package com.moubiecat.api;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * 代表物品建構器
 * @author MouBieCat
 */
public class ItemStackBuilder {

    // 項目實體
    protected ItemStack itemStack;

    /**
     * 建構子
     * @param material 材質
     */
    public ItemStackBuilder(final @NotNull Material material) {
        this(material, 1);
    }

    /**
     * 建構子
     * @param material 材質
     * @param amount 數量
     */
    public ItemStackBuilder(final @NotNull Material material, final int amount) {
        this(new ItemStack(material, amount));
    }

    /**
     * 建構子
     * @param itemStack 物品實例
     */
    public ItemStackBuilder(final @NotNull ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    /**
     * 設定物品類型
     * @param material 材質
     * @return 當前的建構器
     */
    @NotNull
    public final ItemStackBuilder type(final @NotNull Material material) {
        this.itemStack.setType(material);
        return this;
    }

    /**
     * 設定數量
     * @param amount 數量
     * @return 當前的建構器
     */
    @NotNull
    public final ItemStackBuilder amount(final int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    /**
     * 添加附魔
     * @param enchantment 附魔
     * @param level 水平
     * @return 當前的建構器
     */
    @NotNull
    public final ItemStackBuilder enchantment(final @NotNull Enchantment enchantment, final int level) {
        this.itemStack.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    /**
     * 集體附魔
     * @param enchantments 附魔集合
     * @return 當前的建構器
     */
    @NotNull
    public final ItemStackBuilder enchantments(final @NotNull Map<Enchantment, Integer> enchantments) {
        this.itemStack.addUnsafeEnchantments(enchantments);
        return this;
    }

    /**
     * 刪除一個附魔
     * @param enchantment 附魔
     * @return 當前的建構器
     */
    @NotNull
    public final ItemStackBuilder removeEnchantments(final @NotNull Enchantment enchantment) {
        this.itemStack.removeEnchantment(enchantment);
        return this;
    }

    /**
     * 設定本地化名稱
     * @param name 名稱
     * @return 當前的建構器
     */
    @NotNull
    public final ItemStackBuilder localizedName(final @NotNull String name) {
        final ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setLocalizedName(name);
            this.setItemMeta(itemMeta);
        }
        return this;
    }

    /**
     * 物品是否為不可破壞
     * @param unbreakable 是或否
     * @return 當前的建構器
     */
    @NotNull
    public final ItemStackBuilder unbreakable(final boolean unbreakable) {
        final ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setUnbreakable(unbreakable);
            this.setItemMeta(itemMeta);
        }
        return this;
    }

    /**
     * 沒有說明 (尚未之用途)
     * @param data ?
     * @return 當前的建構器
     */
    @NotNull
    public final ItemStackBuilder customModelData(final int data) {
        final ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setCustomModelData(data);
            this.setItemMeta(itemMeta);
        }
        return this;
    }

    /**
     * 沒有說明 (尚未之用途)
     * @param attribute ?
     * @param attributeModifier ?
     * @return 當前的建構器
     */
    @NotNull
    public final ItemStackBuilder attributeModifier(final @NotNull Attribute attribute, final @NotNull AttributeModifier attributeModifier) {
        final ItemMeta itemMeta = this.getItemMeta();
        if(itemMeta != null) {
            itemMeta.addAttributeModifier(attribute, attributeModifier);
            this.setItemMeta(itemMeta);
        }
        return this;
    }

    /**
     * 設定物品的標題名稱
     * @param title 名稱
     * @return 當前的建構器
     */
    @NotNull
    public final ItemStackBuilder displayName(final @NotNull String title) {
        final ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(title);
            this.setItemMeta(itemMeta);
        }
        return this;
    }

    /**
     * 設定物品的敘述說明
     * @param lore 敘述
     * @return 當前的建構器
     */
    @NotNull
    public final ItemStackBuilder lore(final @NotNull List<String> lore) {
        final ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setLore(lore);
            this.setItemMeta(itemMeta);
        }
        return this;
    }

    /**
     * 對物品添加一些特殊標籤
     * @param itemFlag 標籤
     * @return 當前的建構器
     */
    @NotNull
    public final ItemStackBuilder flags(final @NotNull ItemFlag... itemFlag) {
        final ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta != null) {
            itemMeta.addItemFlags(itemFlag);
            this.setItemMeta(itemMeta);
        }
        return this;
    }

    /**
     * 對物品刪除特殊標籤
     * @param itemFlag 標籤
     * @return 當前的建構器
     */
    @NotNull
    public final ItemStackBuilder removeFlags(final @NotNull ItemFlag... itemFlag) {
        final ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta != null) {
            itemMeta.removeItemFlags(itemFlag);
            this.setItemMeta(itemMeta);
        }
        return this;
    }

    /**
     * 將頭顱的 SKIN 換成某位玩家的頭顱 (該物品必須為 PLAYER_HEAD 才可生效)
     * @param player 玩家
     * @return 當前的建構器
     */
    @NotNull
    public final ItemStackBuilder skullMeta(final @NotNull OfflinePlayer player) {
        final ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta instanceof final SkullMeta skullMeta) {
            skullMeta.setOwningPlayer(player);
            this.setItemMeta(itemMeta);
        }
        return this;
    }

    /**
     * 設定物品材質實例
     * @param itemMeta 材質實例
     */
    protected final void setItemMeta(final @NotNull ItemMeta itemMeta) {
        this.itemStack.setItemMeta(itemMeta);
    }

    /**
     * 獲取物品本身的材質實例
     * @return 材質實例
     */
    @Nullable
    protected final ItemMeta getItemMeta() {
        return this.itemStack.getItemMeta();
    }

    /**
     * 將物品建置出來
     * @return 物品
     */
    @NotNull
    public ItemStack build() {
        return this.itemStack;
    }

}