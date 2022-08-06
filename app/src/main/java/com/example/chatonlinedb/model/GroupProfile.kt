package com.example.chatonlinedb.model

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "group_profile_table",  foreignKeys = [ForeignKey(entity = ChatRoom::class,
        parentColumns = arrayOf("Id"),
        childColumns = arrayOf("ChatRoomId"),
        onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(entity = FileModel::class,
        parentColumns = arrayOf("Id"),
        childColumns = arrayOf("PhotoFileId"),
        onDelete = ForeignKey.CASCADE)
    ,
    ForeignKey(entity = FileModel::class,
        parentColumns = arrayOf("Id"),
        childColumns = arrayOf("WallpaperFileId"),
        onDelete = ForeignKey.CASCADE)
])
data class GroupProfile(

    @PrimaryKey(autoGenerate = true)
    var ChatRoomId: Long,

    var GroupName: String,
    var JoinToken: String,

    var About: String,

    @Nullable
    var PhotoFileId: Long,

    @Nullable
    var WallpaperFileId: Long
)
