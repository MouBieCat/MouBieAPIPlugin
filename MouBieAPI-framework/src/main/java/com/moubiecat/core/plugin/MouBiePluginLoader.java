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

package com.moubiecat.core.plugin;

import com.moubiecat.Utils;
import com.moubiecat.api.event.MouBiePluginDisableEvent;
import com.moubiecat.api.event.MouBiePluginEnableEvent;
import com.moubiecat.api.event.MouBiePluginReloadEvent;
import com.moubiecat.api.plugin.MouBiePlugin;
import com.moubiecat.api.plugin.PluginLoader;
import com.moubiecat.api.plugin.PluginRegister;
import com.moubiecat.core.reflect.CraftBukkitReflect;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.*;

/**
 * 用於將沫白插件加載的載入器
 * @author MouBieCat
 */
public final class MouBiePluginLoader
        implements PluginLoader {

    // 插件
    @NotNull
    private final MouBiePlugin plugin;

    // 運行操作管理器
    @NotNull
    private final Map<PluginRegister.ActionType, List<Method>> actionMethods = new LinkedHashMap<>();

    /**
     * 建構子
     * @param plugin 插件
     */
    public MouBiePluginLoader(final @NotNull MouBiePlugin plugin) {
        this.plugin = plugin;

        // 初始化一些東西.. ? (排序優先順序、添加動作至集合)
        this.sortedExecute(PluginRegister.ActionType.ACTION_LOAD);
        this.sortedExecute(PluginRegister.ActionType.ACTION_ENABLE);
        this.sortedExecute(PluginRegister.ActionType.ACTION_DISABLE);
        this.sortedExecute(PluginRegister.ActionType.ACTION_RELOAD);
    }

    /**
     * 執行加載插件動作
     */
    public void executeLoadAction() {
        this.execute(PluginRegister.ActionType.ACTION_LOAD);
    }

    /**
     * 執行啟用插件動作
     */
    public void executeEnableAction() {
        this.execute(PluginRegister.ActionType.ACTION_ENABLE);
        Utils.callEvent(new MouBiePluginEnableEvent(this.plugin));
    }

    /**
     * 執行關閉插件動作
     */
    public void executeDisableAction() {
        this.execute(PluginRegister.ActionType.ACTION_DISABLE);
        Utils.callEvent(new MouBiePluginDisableEvent(this.plugin));
    }

    /**
     * 執行重載插件動作
     */
    public void executeReloadAction() {
        this.execute(PluginRegister.ActionType.ACTION_RELOAD);
        Utils.callEvent(new MouBiePluginReloadEvent(this.plugin));
    }

    /**
     * 調用一個插件註冊動作方法
     * @param actionType 動作類型
     */
    private void execute(final @NotNull PluginRegister.ActionType actionType) {
        final List<Method> methods = this.actionMethods.get(actionType);

        if (methods != null)
            for (final Method method : methods)
                CraftBukkitReflect.invoke(method, this.plugin);
    }

    /**
     * 排序一個插件註冊動作的所有方法(優先等級)
     * @param actionType 動作類型
     */
    private void sortedExecute(final @NotNull PluginRegister.ActionType actionType) {
        final List<Method> methods = new LinkedList<>();

        // 查找有關 Register.class 的類方法並且判斷方法示標動作類型
        for (final Method method : this.plugin.getClass().getDeclaredMethods())
            if (method.isAnnotationPresent(PluginRegister.class) && method.getAnnotation(PluginRegister.class).type().equals(actionType))
                methods.add(method);

        if (methods.size() > 0) {
            // 根據 Register 做優先等級排序
            final List<Method> sortedMethods = methods.stream().sorted(
                    Comparator.comparing(a -> a.getAnnotation(PluginRegister.class).priority())
            ).toList();

            // 添加
            this.actionMethods.put(actionType, sortedMethods);
        }
    }

    /**
     * 獲取該紀錄器插件
     * @return 插件
     */
    @NotNull
    public MouBiePlugin getPlugin() {
        return this.plugin;
    }

}
