package com.example.chatonlinedb.model

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.chatonlinedb.enums.FilePurposeEnum
import java.time.OffsetDateTime
import java.util.*

@Entity(tableName = "file_table")
data class FileModel(
    @PrimaryKey(autoGenerate = true)
    val Id: Long = 0,
    val Name: String,
    val Size: Long,
    val Purpose : FilePurposeEnum,

    val DateUploaded : OffsetDateTime,

    @Nullable
    val DateDeleted: OffsetDateTime
)
