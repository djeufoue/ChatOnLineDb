package com.example.chatonlinedb.model

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.chatonlinedb.enums.UserRoleEnum
import java.time.OffsetDateTime
import java.util.*

@Entity(tableName = "user_chat_room",foreignKeys = [ForeignKey(entity = UserProfile::class,
    parentColumns = arrayOf("Id"),
    childColumns = arrayOf("UserProfileId"),
    onDelete = ForeignKey.CASCADE
),
    ForeignKey(entity = ChatRoom::class,
        parentColumns = arrayOf("Id"),
        childColumns = arrayOf("ChatRoomId"),
        onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(entity = UserProfile::class,
        parentColumns = arrayOf("Id"),
        childColumns = arrayOf("AdderId"),
        onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(entity = UserProfile::class,
        parentColumns = arrayOf("Id"),
        childColumns = arrayOf("BlockerId"),
        onDelete = ForeignKey.CASCADE
    )])
data class UserChatRoom (

    @PrimaryKey(autoGenerate = true)
    var Id: Long = 0,

    var UserProfileId : Long,
    var UserRole: UserRoleEnum,

    var ChatRoomId : Long,

    @Nullable
    var AdderId : Long,

    @Nullable
    var BlockerId : Long,

    var DateAdded: OffsetDateTime,

    @Nullable
    var DateBlocked: OffsetDateTime,

    @Nullable
    var DateDeleted: OffsetDateTime,

    @Nullable
    var DateExited: OffsetDateTime,

    @Nullable
    var DateMuted: OffsetDateTime,

    @Nullable
    var DatePinned : OffsetDateTime
)