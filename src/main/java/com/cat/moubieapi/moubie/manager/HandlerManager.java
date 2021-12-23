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

package com.cat.moubieapi.moubie.manager;

import com.cat.moubieapi.MouBieCat;
import com.cat.moubieapi.api.Debugger;
import com.cat.moubieapi.api.handler.Handler;
import com.cat.moubieapi.api.handler.NBTHandler;
import com.cat.moubieapi.api.manager.NMSManager;
import com.cat.moubieapi.moubie.handler.v1_18_R1.NBTTagHandler_v1_18_R1;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

/**
 * 記錄所有有關 nms 操作類的管理器
 * @author MouBieCat
 */
public final class HandlerManager
        extends ManagerAbstract<HandlerManager.NMSHandlerType, Handler>
        implements NMSManager {

    /**
     * NMS操作類的列舉類型
     */
    public enum NMSHandlerType { NBT_TAG }

    /**
     * 建構子
     */
    public HandlerManager() {
        // 獲取當前運行的 Bukkit 版本
        final String versionStr = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

        // 判斷版本，如果該插件不支持。自動卸載該插件
        try {
            if ("v1_18_R1".equals(versionStr))
                this.add(NMSHandlerType.NBT_TAG, new NBTTagHandler_v1_18_R1());

            else
                throw new ClassNotFoundException();

        } catch (final ClassNotFoundException e) {
            // 卸載插件
            Debugger.warning(MouBieCat.getInstance(), "§c該插件不支持您伺服器的版本。請伺服器所有者回報給插件作者！");
            Bukkit.getPluginManager().disablePlugin(MouBieCat.getInstance());
        }
    }

    /**
     * 獲取操作NBTTag的介面類
     * @return NBTHandler
     */
    @NotNull
    public NBTHandler getNbtHandler() {
        return (NBTHandler) this.get(NMSHandlerType.NBT_TAG);
    }

    /**
     * 獲取一個 NMS 操作類
     * @param key k 操作類型
     * @return NMS操作類
     */
    @NotNull
    public Handler get(final @NotNull NMSHandlerType key) {
        return this.manager.get(key);
    }

}
