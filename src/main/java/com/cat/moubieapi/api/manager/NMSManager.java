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

package com.cat.moubieapi.api.manager;

import com.cat.moubieapi.api.handler.Handler;
import com.cat.moubieapi.api.handler.NBTHandler;
import com.cat.moubieapi.moubie.manager.HandlerManager;
import org.jetbrains.annotations.NotNull;

/**
 * 記錄所有有關 nms 操作類的管理器介面
 * @author MouBieCat
 */
public interface NMSManager
        extends Manager<HandlerManager.NMSHandlerType, Handler> {

    /**
     * 獲取操作NBTTag的介面類
     * @return NBTHandler
     */
    @NotNull NBTHandler getNbtHandler();

    /**
     * 獲取一個 NMS 操作類
     * @param key k 操作類型
     * @return NMS操作類
     */
    @NotNull Handler get(final @NotNull HandlerManager.NMSHandlerType key);

}
