package com.example.chatonlinedb.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chatonlinedb.model.Register

@Dao
interface RegisterDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun register(user: Register)

    @Query("SELECT * FROM register_table WHERE email = :UserEmail")
    fun findUserByEmail(UserEmail: String ): LiveData<List<Register>>
}