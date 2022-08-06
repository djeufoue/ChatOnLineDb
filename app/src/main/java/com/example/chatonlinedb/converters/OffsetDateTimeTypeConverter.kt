package com.example.chatonlinedb.converters

import androidx.room.TypeConverter
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class OffsetDateTimeTypeConverter {

    private val dateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    @TypeConverter
    fun dateStringToOffsetDateTime(dateString : String): OffsetDateTime {
        return OffsetDateTime.from(dateTimeFormatter.parse(dateString))
    }

    @TypeConverter
    fun dateTimeToOffsetDateTimeString(date: OffsetDateTime): String {
        return date.format(dateTimeFormatter)
    }
}