package com.example.chatonlinedb.viewmodel

import androidx.lifecycle.LiveData
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatonlinedb.R
import com.example.chatonlinedb.data.ChatOnLineDatabase
import com.example.chatonlinedb.model.Register
import com.example.chatonlinedb.repository.RegisterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    var findUserByEmail: RegisterRepository
    private val repository: RegisterRepository

    init {
        val userEmail: String = R.id.email_editText.toString()
        val registerDao = ChatOnLineDatabase.getDatabase(application).registerDao()
        repository = RegisterRepository(registerDao)
        findUserByEmail = RegisterRepository(registerDao)
    }

    fun register(user: Register) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.register(user)
        }
    }

      fun checkEmail(userEmail: String): LiveData<List<Register>>? {
         var register: LiveData<List<Register>>? = null
        viewModelScope.launch(Dispatchers.IO) {
           register = repository.findUserByEmail(userEmail)
        }
         return register
    }
}