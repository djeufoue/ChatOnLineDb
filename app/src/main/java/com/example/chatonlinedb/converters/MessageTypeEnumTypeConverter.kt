package com.example.chatonlinedb.converters

import androidx.room.TypeConverter
import com.example.chatonlinedb.enums.MessageTypeEnum

class MessageTypeEnumTypeConverter {

    // Use to convert String to enum when retrieving data from the database
    @TypeConverter
    fun toMessageType(value: String) = enumValueOf<MessageTypeEnum>(value)

    // Use to convert Enum to String when creating an entity with columns of Enums type
    @TypeConverter
    fun fromMessageType(value: MessageTypeEnum) = value.name
}