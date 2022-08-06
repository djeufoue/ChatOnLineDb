package com.example.chatonlinedb.model

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.OffsetDateTime
import java.util.*

@Entity(tableName = "message_tag_table",foreignKeys = [ForeignKey(entity = ChatRoom::class,
    parentColumns = arrayOf("Id"),
    childColumns = arrayOf("ChatRoomId"),
    onDelete = ForeignKey.CASCADE
),
    ForeignKey(entity = MessageTag::class,
    parentColumns = arrayOf("Id"),
    childColumns = arrayOf("ParentId"),
    onDelete = ForeignKey.CASCADE
),
    ForeignKey(entity = UserChatRoom::class,
        parentColumns = arrayOf("Id"),
        childColumns = arrayOf("CreatorId"),
        onDelete = ForeignKey.CASCADE
    )])
data class MessageTag(

    @PrimaryKey(autoGenerate = true)
    var Id: Long,

    var Name: String,

    var ChatRoomId: Long,

    @Nullable
    var ParentId: Long,

    @Nullable
    var CreatorId: Long,

    var DateCreated: OffsetDateTime,

    @Nullable
    var DateDeleted: OffsetDateTime
)
