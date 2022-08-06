package com.example.chatonlinedb.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "register_table")
data class Register(
    @PrimaryKey(autoGenerate = true)
    val Id: Long = 0,
    val email: String,
    val password: String,
    val confirmPassword: Boolean
)
