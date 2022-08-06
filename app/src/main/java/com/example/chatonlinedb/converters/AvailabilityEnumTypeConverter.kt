package com.example.chatonlinedb.converters

import androidx.room.TypeConverter
import com.example.chatonlinedb.enums.AvailabilityEnum

class AvailabilityEnumTypeConverter {

    // Use to convert String to enum when retrieving data from the database
    @TypeConverter
    fun toAvailability(value: String) = enumValueOf<AvailabilityEnum>(value)

    // Use to convert Enum to String when creating an entity with columns of Enums type
    @TypeConverter
    fun fromAvailability(value: AvailabilityEnum) = value.name
}