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

package com.moubieapi.api.yaml;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 代表一個插件生成的資源檔
 * @author MouBieCat
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Resource {

    /**
     * 代表來自哪個類的資源檔
     * @return 類
     */
    @NotNull Class<? extends Resource> from();

    /**
     * 代表檔案名稱
     * @return 檔案名稱
     */
    @NotNull String locate();

    /**
     * 代表一個可以獲取資源檔的類方法
     * @author MouBieCat
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface ResourceMethod {

        /**
         * 代表函數名稱
         * @return 函數名稱
         */
        @NotNull String name();

        /**
         *
         * @return 獲取到的回傳類
         */
        @NotNull Class<?> returnType();

    }

}
