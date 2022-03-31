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
