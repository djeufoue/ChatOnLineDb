package com.example.chatonlinedb.model

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.chatonlinedb.enums.MessageTypeEnum
import java.time.OffsetDateTime
import java.util.*

@Entity(tableName = "message_sent_table",foreignKeys = [ForeignKey(entity = UserChatRoom::class,
    parentColumns = arrayOf("Id"),
    childColumns = arrayOf("SenderId"),
    onDelete = ForeignKey.CASCADE
),
    ForeignKey(entity = MessageTag::class,
    parentColumns = arrayOf("Id"),
    childColumns = arrayOf("MessageTagId"),
    onDelete = ForeignKey.CASCADE
),
    ForeignKey(entity = MessageSent::class,
        parentColumns = arrayOf("Id"),
        childColumns = arrayOf("LinkedId"),
        onDelete = ForeignKey.CASCADE
    ),

    ForeignKey(entity = UserProfile::class,
        parentColumns = arrayOf("Id"),
        childColumns = arrayOf("AuthorId"),
        onDelete = ForeignKey.CASCADE
    ),

    ForeignKey(entity = FileModel::class,
        parentColumns = arrayOf("Id"),
        childColumns = arrayOf("FileId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class MessageSent(
    @PrimaryKey(autoGenerate = true)
    var Id: Long,

    var SenderId: Long,

    var MessageTagId : Long,

    var MessageType: MessageTypeEnum,

    @Nullable
    var LinkedId: Long,

    @Nullable
    var AuthorId : Long,

    @Nullable
    var FileId : Long,

    var Body: String,

    var DateSent: OffsetDateTime,
    var DateCreated: OffsetDateTime,

    @Nullable
    var DateDeleted: OffsetDateTime,

    @Nullable
    var DateStarred: OffsetDateTime
)
