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

package com.moubiecat.api.inventory.gui;

import org.bukkit.event.inventory.InventoryEvent;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 代表一些可取消的事件操作
 * 警告：
 *  如果介面為異步處理，請確保取消 InventoryClickEvent 的事件。除非您有其它想法。否則這是必須的。
 *  {@code @GUIEventCancelRegister(}  cancels = { InventoryClickEvent.class } )
 *
 *  或是在您的介面類中聲明
 *  {@code @GUIEventSynchronousRegister}
 *  讓介面同步觸發。但您必須在適當的情況，自行處理取消事件，否則按鈕將會被意外拋出。
 * @author MouBieCat
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface GUIEventCancelRegister {

    /**
     * 要強制取消事件的事件類陣列
     * @return 類陣列
     */
    @NotNull Class<? extends InventoryEvent>[] cancels() default {};

}
