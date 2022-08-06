package com.example.chatonlinedb.converters

import androidx.room.TypeConverter
import com.example.chatonlinedb.enums.ChatRoomTypeEnum

class ChatRoomTypeEnumTypeConverter {

    // Use to convert String to enum when retrieving data from the database
    @TypeConverter
    fun toChatRoomType(value: String) = enumValueOf<ChatRoomTypeEnum>(value)

    // Use to convert Enum to String when creating an entity with columns of Enums type
    @TypeConverter
    fun fromChatRoomType(value: ChatRoomTypeEnum) = value.name
}