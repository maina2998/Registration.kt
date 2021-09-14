package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Models.LoginRequest
import com.example.myapplication.UI.Constants
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.viewmodel.UserViewModel


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs:SharedPreferences
    val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding =ActivityLoginBinding.inflate(layoutInflater)
        sharedPrefs = getSharedPreferences(Constants.REGISTRATION_PREFS, Context.MODE_PRIVATE)
        logInStudent()

    }

    override fun onResume() {
        super.onResume()

         userViewModel.loginLiveData.observe(this) { loginResponse ->
             var accessToken = loginResponse.accesToken
             var editor = sharedPrefs.edit()
             editor.putString(Constants.ACCESS_TOKEN, accessToken)
             editor.putString(Constants.STUDENT_ID, loginResponse.studentId)
             sharedPrefs.edit().putString(Constants.ACCESS_TOKEN, accessToken).apply()
            binding.tilpassword.visibility = View.GONE
             if (!loginResponse.studentId.isNullOrEmpty()) {
                Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_LONG).show()
                 startActivity(Intent(baseContext, coursesRVAdapter::class.java))
            }
        }


    }
    fun logInStudent(){
        var error=false
        binding.btnToast.setOnClickListener {

            var email = binding.tilemail.editText.toString()
            if (email.isEmpty()){
                error=true
                binding.tilemail.setError("This field is required")
            }

            var password = binding.tilpassword.editText.toString()
            if (password.isEmpty()){
                error=true
                binding.tilpassword.setError("This field is required")
            }
            if(!error){
                binding.btnToast.visibility= View.GONE
                var lrgRequest=LoginRequest(
                    email =email,
                    password = password
                )


            }

        }
        fun observeLoginResponse(){

        }

    }
}







