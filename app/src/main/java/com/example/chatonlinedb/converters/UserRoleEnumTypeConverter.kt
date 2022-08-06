package com.example.chatonlinedb.converters

import androidx.room.TypeConverter
import com.example.chatonlinedb.enums.UserRoleEnum

class UserRoleEnumTypeConverter {

    // Use to convert String to enum when retrieving data from the database
    @TypeConverter
    fun toUserRole(value: String) = enumValueOf<UserRoleEnum>(value)

    // Use to convert Enum to String when creating an entity with columns of Enums type
    @TypeConverter
    fun fromUserRole(value: UserRoleEnum) = value.name
}