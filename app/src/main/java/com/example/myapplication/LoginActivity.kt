package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.view.View.inflate
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.API.ApiClient
import com.example.myapplication.API.ApiInterface
import com.example.myapplication.Models.LoginRequest
import com.example.myapplication.databinding.ActivityAnimalsBinding.inflate
import com.example.myapplication.databinding.ActivityCouresesBinding.inflate
import com.example.myapplication.databinding.ActivityCoursesBinding.inflate
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.databinding.ActivityLoginBinding.inflate
import com.example.myapplication.databinding.ActivityMainBinding.inflate
import com.example.myapplication.databinding.ActivityScheduleBinding.inflate
import com.example.myapplication.databinding.CourseListItemBinding.inflate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.myapplication.ActivityLoginBinding as ActivityLoginBinding1

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding =ActivityLoginBinding.inflate(layoutInflater)
        logInStudent()

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
                var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
                val request= retrofit.logInStudent(lrgRequest)
                request.enqueue(object : Callback<LoginRequest> {
                    override fun onResponse(
                        call: Call<LoginRequest>,
                        response: Response<LoginRequest>
                    ) {
                        if (response.isSuccessful){
                            Toast.makeText(baseContext,"Login is succesful", Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(baseContext,response.errorBody()?.string(), Toast.LENGTH_LONG).show()
                        }

                    }

                    override fun onFailure(call: Call<LoginRequest>, t: Throwable) {
//                        binding.pbRegistration.visibility=View.GONE
                        Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
                    }

                })
            }

        }

    }
}

class ActivityLoginBinding {

}
