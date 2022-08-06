package com.example.chatonlinedb.model

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.chatonlinedb.enums.DevicePlatformEnum
import java.time.OffsetDateTime
import java.util.*

@Entity(tableName = "deviceUsed_table", foreignKeys = [ForeignKey(entity = UserProfile::class,
    parentColumns = arrayOf("Id"),
    childColumns = arrayOf("UserProfileId"),
    onDelete = ForeignKey.CASCADE
)])
data class DeviceUsed(

    @PrimaryKey(autoGenerate = true)
    val Id: Long,

    var UserProfileId: Long,

    var Platform: DevicePlatformEnum,

    var Language : String,
    var TimeZone: String,
    val DateCreated : OffsetDateTime,
    var DateUpdated: OffsetDateTime,

    @Nullable
    val DateDeleted: OffsetDateTime,

    var PushNotificationToken : String,

    @Nullable
    var DateTokenProvided : OffsetDateTime
)
