package com.moubieapi.api.inventory.gui;

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

    // 介面事件類型
    @NotNull EventType type();

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

    /**
     * 使用者介面事件觸發類型
     * @author MouBieCat
     */
    enum EventType {
        // 開啟
        OPEN_INVENTORY(0, "OPEN"),
        // 點擊
        CLICK_INVENTORY(1, "CLICK"),
        // 關閉
        CLOSE_INVENTORY(2, "CLOSE");

        // 類型ID
        private final long type;

        // 類型名稱
        private final String name;

        /**
         * 建構子
         * @param type 類型ID
         * @param name 類型名稱
         */
        EventType(final long type, final @NotNull String name) {
            this.type = type;
            this.name = name;
        }

        /**
         * 獲取類型ID
         * @return id
         */
        public final long getTypeId() {
            return this.type;
        }

        /**
         * 獲取類型名稱
         * @return Name
         */
        @NotNull
        public final String getName() {
            return name;
        }
    }

}
