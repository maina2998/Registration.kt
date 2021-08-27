package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Models.LoginRequest
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.viewmodel.UserViewModel


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    val UserViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding =ActivityLoginBinding.inflate(layoutInflater)
        logInStudent()

    }

    override fun onResume() {
        super.onResume()

        var UserViewModel = loginLiveDta.observe(this) { loginResponse ->
            binding.tilpassword.visibility = View.GONE
            if (!loginResponse.student.isNullOrEmpty()) {
                Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_LONG).show()
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

    }
}






