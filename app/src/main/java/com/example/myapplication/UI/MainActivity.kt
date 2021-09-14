package com.example.myapplication.UI

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModel
import com.example.myapplication.API.ApiClient
import com.example.myapplication.API.ApiInterface
import com.example.myapplication.LoginActivity
import com.example.myapplication.Models.RegistrationRequest
import com.example.myapplication.Models.RegistrationResponse
import com.example.myapplication.coursesRVAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewmodel.UserViewModel
import retrofit2.Response
import androidx.activity.viewModels as viewModels1
import kotlin.Error as Error1

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPrefs: SharedPreferences
    val userViewModel: UserViewModel by viewModels1()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupSpinner()
        clickRegistration()
        sharedPrefs = getSharedPreferences(Constants.REGISTRATION_PREFS,Context.MODE_PRIVATE)
        redirectUser()
    }

    override fun onResume() {
        super.onResume()
        userViewModel.registrationLiveData.observe(this) { regResponse ->
            binding.pdregistration.visibility = View.GONE
            if (!regResponse.studentId.isNullOrEmpty()) {
                Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_LONG).show()
            }
        }

    }
fun setupSpinner() {


    var nationalities = arrayOf("Kenya","Rwandan","Sudan","Uganda")
    var nationalityAdapter = ArrayAdapter(baseContext,android.R.layout.simple_spinner_item,nationalities)
    nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    binding.spNationality.adapter =nationalityAdapter

}

        fun clickRegistration() {
           binding.etButtonLBI.setOnClickListener {

                var name = binding.etName.text.toString()
                var dob = binding.etDOB.text.toString()
                var idNo = binding.etPassword.text.toString()
                var nationality = binding.spNationality.selectedItem.toString()
                var phone = binding.etPhoneNumber.text.toString()
                var email = binding.etEmail.text.toString()
                var password = binding.etPassword.text.toString()


              binding.pdregistration.visibility = View.VISIBLE
              var regRequest = RegistrationRequest(
                  name = name,
                  phoneNumber = phone,
                  email = email,
                  dateOfBirth = dob,
                  nationality = nationality.toUpperCase(),
                  password = password
              )


           }
            }
    fun  redirectUser() {
        var accessToken = sharedPrefs.getString(Constants.ACCESS_TOKEN , Constants.EMPTY_STRING)!!
        if (accessToken.isNotEmpty() && accessToken.isNotBlank()) {
            startActivity(Intent(this , coursesRVAdapter::class.java))
        }
        else {
            startActivity(Intent(this , LoginActivity::class.java))
        }

    }
    }








