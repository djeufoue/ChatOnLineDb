package com.example.chatonlinedb.model

import androidx.annotation.Nullable
import androidx.room.*
import com.example.chatonlinedb.enums.AvailabilityEnum
import java.time.OffsetDateTime

@Entity(tableName = "user_profile_table",
        foreignKeys = [ForeignKey(entity = FileModel::class,
                                  parentColumns = arrayOf("Id"),
                                  childColumns = arrayOf("PhotoFileId"),
                                  onDelete = ForeignKey.CASCADE
),
        ForeignKey(entity = FileModel::class,
                   parentColumns = arrayOf("Id"),
                   childColumns = arrayOf("WallpaperFileId"),
                   onDelete = ForeignKey.CASCADE)]
)
data class UserProfile(
    @PrimaryKey(autoGenerate = true)
    var Id : Long = 0,
    var Name: String,
    var About: String,

    //foreign key
    @Nullable
    var PhotoFileId : Long?,

    @Nullable
    var WallpaperFileId : Long?,
    val DateCreated : OffsetDateTime,

    @Nullable
    val DateDeleted : OffsetDateTime?,
    var LastConnected: OffsetDateTime,
    var Availability : AvailabilityEnum
)
