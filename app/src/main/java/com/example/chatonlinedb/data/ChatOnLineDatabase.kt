package com.example.chatonlinedb.data

import android.content.Context
import androidx.room.*
import com.example.chatonlinedb.converters.*
import com.example.chatonlinedb.dao.*
import com.example.chatonlinedb.model.*

@Database(entities =[Register::class,
    UserProfile::class, FileModel::class,
    ChatRoom::class, DeviceUsed::class,
    GroupProfile::class, MessageSent::class,
    MessageReceived::class, UserChatRoom::class,
    MessageTag::class], version = 1, exportSchema = false)
@TypeConverters(AvailabilityEnumTypeConverter::class, ChatRoomTypeEnumTypeConverter::class,
                DevicePlatformEnumTypeConverter::class, FilePurposeEnumTypeConverter::class,
                MessageReactionEnumTypeConverter::class, MessageTypeEnumTypeConverter::class,
                UserRoleEnumTypeConverter::class, OffsetDateTimeTypeConverter::class )
abstract class ChatOnLineDatabase: RoomDatabase() {

    abstract fun registerDao(): RegisterDao
    abstract fun userProfileDao(): UserProfileDao
    abstract fun fileDao(): FileDao
    abstract fun chatRoomDao(): ChatRoomDao
    abstract fun groupProfileDao(): GroupProfileDao
    abstract fun deviceUsedDao(): DeviceUsedDao
    abstract fun messageSentDao(): MessageSentDao
    abstract fun messageReceivedDao(): MessageReceivedDao
    abstract fun messageTagDao(): MessageTagDao

    companion object {
        @Volatile
        private var INSTANCE: ChatOnLineDatabase? = null

        fun getDatabase(context: Context): ChatOnLineDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ChatOnLineDatabase::class.java,
                    "chatOnLine_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}