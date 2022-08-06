package com.example.chatonlinedb.fragments.register

import android.app.Application
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.chatonlinedb.R
import com.example.chatonlinedb.dao.RegisterDao
import com.example.chatonlinedb.data.ChatOnLineDatabase
import com.example.chatonlinedb.model.Register
import com.example.chatonlinedb.repository.RegisterRepository
import com.example.chatonlinedb.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterFragment : Fragment() {

    lateinit var register : LiveData<List<Register>>
    private lateinit var mRegisterViewModel: RegisterViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view  = inflater.inflate(R.layout.fragment_register, container, false)

        mRegisterViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        view.register_btn.setOnClickListener {
            register()
        }

        view.SignIn_btn.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        return view
    }

    private fun register() {
        val email = email_editText.text.toString()
        val password = password_editText.text.toString()
        val confirmPassword = confirmPassword_editText.text.toString()

        if(inputCheck(email, password, confirmPassword)){

            if(!samePassword(password, confirmPassword)){
                Toast.makeText(requireContext(), "Passwords do not match", Toast.LENGTH_LONG).show()
            }else{

                // Create register object if inputCheck is true
                val user = Register(0,email, password, samePassword(password, confirmPassword))

              //  var RESULT1 = mRegisterViewModel.checkEmail(email)
              //  Log.d("OUT", RESULT1)

                    //register = mRegisterViewModel.checkEmail(email)!!
                    //Log.d("OUTPUT", register.toString())*/


               /* if(register == null){
                    Toast.makeText(requireContext(), "Email Exist", Toast.LENGTH_SHORT).show()
                    return
                } else {*/
                    mRegisterViewModel.register(user)
                    Toast.makeText(requireContext(), "User Account Created Successfully", Toast.LENGTH_LONG).show()

                    //Navigate to Login Page
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                //}
            }
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_LONG).show()
        }

    }

    // return false if one or all those field are empty and true otherwise
    private fun inputCheck(email: String, password: String, confirmPassword: String): Boolean{
        return !(TextUtils.isEmpty(email) && TextUtils.isEmpty(password) && TextUtils.isEmpty(confirmPassword))
    }

    private fun samePassword(password: String, confirmPassword: String): Boolean{
        return password == confirmPassword
    }
}