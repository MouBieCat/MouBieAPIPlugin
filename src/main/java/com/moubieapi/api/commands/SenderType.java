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

package com.moubieapi.api.commands;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 代表一個指令運行接受的發送者類型
 * @author MouBieCat
 */
public enum SenderType {

    // 伺服器後台類型
    CONSOLE_SENDER(SenderType.CONSOLE_SENDER_ID, SenderType.CONSOLE_SENDER_NAME),
    // 方塊類型
    BLOCK_SENDER(SenderType.BLOCK_SENDER_ID, SenderType.BLOCK_SENDER_NAME),
    // 玩家類型
    PLAYER_SENDER(SenderType.PLAYER_SENDER_ID, SenderType.PLAYER_SENDER_NAME),
    // 任何可發送指令的類型
    ANY_SENDER(SenderType.ANY_SENDER_ID, SenderType.ANY_SENDER_NAME);

    private static final long CONSOLE_SENDER_ID = 1;
    private static final String CONSOLE_SENDER_NAME = "Console_Sender";

    private static final long BLOCK_SENDER_ID = 2;
    private static final String BLOCK_SENDER_NAME= "Block_Sender";

    private static final long PLAYER_SENDER_ID = 3;
    private static final String PLAYER_SENDER_NAME = "PlayerSender";

    private static final long ANY_SENDER_ID = 4;
    private static final String ANY_SENDER_NAME = "CommandSender";

    // 發送者類型
    private final CommandSenderInfo info;

    /**
     * 建構子
     * @param id 指令發送類型ID
     * @param name 指令發送類型名
     */
    SenderType(long id, @NotNull String name) {
        this.info = new CommandSenderInfo(id, name);
    }

    /**
     * 獲取指令發送類型ID
     * @return 類型ID
     */
    public final long getId() {
        return this.info.id();
    }

    /**
     * 獲取指令發送類型名
     * @return 類型名
     */
    @NotNull
    public final String getName() {
        return this.info.name();
    }

    /**
     * 根據ID查找一個發送者類型
     * @param id 發送者ID
     * @return 發送者類型
     */
    @Nullable
    public static SenderType getSenderTypeById(long id) {
        for (final SenderType type : SenderType.values())
            if (type.getId() == id)
                return type;

        return null;
    }

    /**
     * 根據名稱查找一個發送者類型
     * @param name 發送者ID
     * @return 發送者類型
     */
    @Nullable
    public static SenderType getSenderTypeByName(@NotNull String name) {
        for (final SenderType type : SenderType.values())
            if (type.getName().equalsIgnoreCase(name))
                return type;

        return null;
    }


    /**
     * 有關發送者資訊
     * @param id 指令發送者ID
     * @param name 指令發送者名稱
     * @author MouBieCat
     */
    private record CommandSenderInfo(long id, @NotNull String name) {

        /**
         * 建構子
         * @param id   指令發送類型ID
         * @param name 指令發送類型名
         */
        private CommandSenderInfo(long id, @NotNull String name) {
            this.id = id;
            this.name = name;
        }
    }

}
