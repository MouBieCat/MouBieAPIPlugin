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

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 代表使用者介面處理程序
 * @author MouBieCat
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GUIRegister {

    // 事件優先等級
    @NotNull EventPriority priority()
            default EventPriority.NORMAL;

    /**
     * 代表一個事件的優先級別
     * @author MouBieCat
     */
    enum EventPriority {
        // 最高
        HIGHEST(0),
        // 高
        HIGH(1),
        // 一般
        NORMAL(2),
        // 低
        LOW(3),
        // 最低
        LOWEST(4);

        // 優先等級
        private final long priority;

        /**
         * 建構子
         * @param priority 優先等級
         */
        EventPriority(long priority) {
            this.priority = priority;
        }

        /**
         * 獲取優先級
         * @return 優先級
         */
        public final long getPriority() {
            return this.priority;
        }
    }

}
