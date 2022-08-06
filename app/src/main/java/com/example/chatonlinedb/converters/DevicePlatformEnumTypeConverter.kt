package com.example.chatonlinedb.converters

import androidx.room.TypeConverter
import com.example.chatonlinedb.enums.DevicePlatformEnum

class DevicePlatformEnumTypeConverter {
    // Use to convert String to enum when retrieving data from the database
    @TypeConverter
    fun toDevicePlatform(value: String) = enumValueOf<DevicePlatformEnum>(value)

    // Use to convert Enum to String when creating an entity with columns of Enums type
    @TypeConverter
    fun fromDevicePlatform(value: DevicePlatformEnum) = value.name
}