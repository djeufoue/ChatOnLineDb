package com.example.chatonlinedb.converters

import androidx.room.TypeConverter
import com.example.chatonlinedb.enums.MessageReactionEnum

class MessageReactionEnumTypeConverter {

    // Use to convert String to enum when retrieving data from the database
    @TypeConverter
    fun toMessageReaction(value: String) = enumValueOf<MessageReactionEnum>(value)

    // Use to convert Enum to String when creating an entity with columns of Enums type
    @TypeConverter
    fun fromMessageReaction(value: MessageReactionEnum) = value.name
}