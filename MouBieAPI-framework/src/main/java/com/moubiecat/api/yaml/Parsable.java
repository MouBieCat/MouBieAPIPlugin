package com.moubiecat.api.yaml;

import com.moubiecat.api.manager.Manager;
import com.moubiecat.core.yaml.Loader;
import org.jetbrains.annotations.NotNull;

/**
 * 代表具有解析功能的類
 * @param <T> 檔案加載器
 * @author MouBieCat
 */
public interface Parsable<M extends Manager<?, ?>, T extends Loader> {

    /**
     * 解析
     * @param manager 管理器
     * @param loader 檔案加載器
     * @return 加載數量
     */
    int parsing(@NotNull M manager, @NotNull T loader);

}
