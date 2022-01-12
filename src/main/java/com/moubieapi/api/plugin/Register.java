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

package com.moubieapi.api.plugin;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 插件註冊動作示標符
 * @author MouBieCat
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Register {

    // 註冊名稱
    @NotNull
    String name();

    // 動作類型
    @NotNull
    ActionType type();

    // 動作優先等級 (預設 5)
    int priority() default 5;

    /**
     * 代表一個動作類型
     * @author MouBieCat
     */
    enum ActionType {

        // 加載時
        ACTION_LOAD(0),

        // 啟用時
        ACTION_ENABLE(1),

        // 卸載時
        ACTION_DISABLE(2),

        // 重載時
        ACTION_RELOAD(3);

        // 操作類型ID
        private final long id;

        /**
         * 建構子
         * @param id 操作類型ID
         */
        ActionType(long id) {
            this.id = id;
        }

        /**
         * 獲取操作類型ID
         * @return ID
         */
        public final long getId() {
            return this.id;
        }
    }

}
