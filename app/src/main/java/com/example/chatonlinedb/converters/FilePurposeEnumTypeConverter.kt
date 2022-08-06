package com.example.chatonlinedb.converters

import androidx.room.TypeConverter
import com.example.chatonlinedb.enums.FilePurposeEnum

class FilePurposeEnumTypeConverter {

    // Use to convert String to enum when retrieving data from the database
    @TypeConverter
    fun toFilePurpose(value: String) = enumValueOf<FilePurposeEnum>(value)

    // Use to convert Enum to String when creating an entity with columns of Enums type
    @TypeConverter
    fun fromFilePurpose(value: FilePurposeEnum) = value.name
}