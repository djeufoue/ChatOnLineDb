package com.example.chatonlinedb.repository

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.example.chatonlinedb.R
import com.example.chatonlinedb.dao.RegisterDao
import com.example.chatonlinedb.model.Register
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterRepository(private val registerDao: RegisterDao) {

  var userEmail: String =R.id.email_editText.toString()

   /* suspend fun findUserByEmail(userEmail: String?): String {
        return registerDao.findUserByEmail(userEmail)
    }*/

    suspend fun findUserByEmail(userEmail: String): LiveData<List<Register>> {
        return  registerDao.findUserByEmail(userEmail)
    }

    suspend fun register(register: Register){
        registerDao.register(register)
    }
}