package com.example.chatonlinedb.model

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.chatonlinedb.enums.ChatRoomTypeEnum
import java.time.OffsetDateTime
import java.util.*

@Entity(tableName = "chat_room_table", foreignKeys = [ForeignKey(entity = UserProfile::class,
    parentColumns = arrayOf("Id"),
    childColumns = arrayOf("CreatorId"),
    onDelete = ForeignKey.CASCADE
)])
data class ChatRoom(

    @PrimaryKey(autoGenerate = true)
    val Id :Long,
    var Type : ChatRoomTypeEnum,

    var CreatorId: Long,

    var DateCreated: OffsetDateTime,

    @Nullable
    var DateDeleted :OffsetDateTime,

    //var GroupProfile: String

)
