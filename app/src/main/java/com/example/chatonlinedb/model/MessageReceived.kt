package com.example.chatonlinedb.model

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.chatonlinedb.enums.MessageReactionEnum
import java.time.OffsetDateTime
import java.util.*

@Entity(tableName = "message_received",foreignKeys = [
    ForeignKey(entity = UserChatRoom::class,
    parentColumns = arrayOf("Id"),
    childColumns = arrayOf("ReceiverId"),
    onDelete = ForeignKey.CASCADE
),
    ForeignKey(entity = MessageSent::class,
        parentColumns = arrayOf("Id"),
        childColumns = arrayOf("MessageSentId"),
        onDelete = ForeignKey.CASCADE
    )])
data class MessageReceived(

    @PrimaryKey(autoGenerate = true)
    var Id: Long,

    var ReceiverId : Long,

    var MessageSentId : Long,

    var DateCreated: OffsetDateTime,
    var DateReceived: OffsetDateTime,

    @Nullable
    var DateRead: OffsetDateTime,

    @Nullable
    var DateDeleted: OffsetDateTime,

    @Nullable
    var DateStarred: OffsetDateTime,

    var Reaction: MessageReactionEnum
)