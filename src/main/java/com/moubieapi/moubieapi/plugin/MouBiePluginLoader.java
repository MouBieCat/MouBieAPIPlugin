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

package com.moubieapi.moubieapi.plugin;

import com.moubieapi.api.plugin.MouBiePlugin;
import com.moubieapi.api.plugin.PluginLoader;
import com.moubieapi.api.plugin.Register;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
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
    private final Map<Register.ActionType, List<Method>> actionMethods = new LinkedHashMap<>();

    /**
     * 建構子
     * @param plugin 插件
     */
    public MouBiePluginLoader(final @NotNull MouBiePlugin plugin) {
        this.plugin = plugin;

        // 初始化一些東西.. ? (排序優先順序、添加動作至集合)
        this.shortExecute(Register.ActionType.ACTION_LOAD);
        this.shortExecute(Register.ActionType.ACTION_ENABLE);
        this.shortExecute(Register.ActionType.ACTION_DISABLE);
        this.shortExecute(Register.ActionType.ACTION_RELOAD);
    }

    /**
     * 執行加載插件動作
     */
    public void executeLoadAction() {
        this.execute(Register.ActionType.ACTION_LOAD);
    }

    /**
     * 執行啟用插件動作
     */
    public void executeEnableAction() {
        this.execute(Register.ActionType.ACTION_ENABLE);
    }

    /**
     * 執行關閉插件動作
     */
    public void executeDisableAction() {
        this.execute(Register.ActionType.ACTION_DISABLE);
    }

    /**
     * 執行重載插件動作
     */
    public void executeReloadAction() {
        this.execute(Register.ActionType.ACTION_RELOAD);
    }

    /**
     * 調用一個插件註冊動作方法
     * @param actionType 動作類型
     */
    private void execute(final @NotNull Register.ActionType actionType) {
        final List<Method> methods = this.actionMethods.get(actionType);

        if (methods != null)
            for (final Method method : methods) {
                try {
                    // 設置該方法可訪問
                    method.setAccessible(true);

                    // 調用
                    method.invoke(this.plugin);
                } catch (final InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                    this.plugin.getDebugger().warning("§c插件註冊方法 §6" + method.getName() + " §c調用失敗，這是一個錯誤訊息。");
                }
            }
    }

    /**
     * 排序一個插件註冊動作的所有方法(優先等級)
     * @param actionType 動作類型
     */
    private void shortExecute(final @NotNull Register.ActionType actionType) {
        final List<Method> methods = new LinkedList<>();

        // 查找有關 Register.class 的類方法並且判斷方法示標動作類型
        for (final Method method : this.plugin.getClass().getDeclaredMethods())
            if (method.isAnnotationPresent(Register.class) && method.getAnnotation(Register.class).type().equals(actionType))
                methods.add(method);

        if (methods.size() > 0) {
            // 根據 Register 做優先等級排序
            final List<Method> sortedMethods = methods.stream().sorted(
                    Comparator.comparing(a -> a.getAnnotation(Register.class).priority())
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
