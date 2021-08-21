package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.View
import android.widget.*
import com.example.myapplication.API.ApiClient
import com.example.myapplication.API.ApiInterface
import com.example.myapplication.Models.RegistrationRequest
import com.example.myapplication.Models.RegistrationResponse
import com.example.myapplication.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupSpinner()
        clickRegistration()
    }
fun setupSpinner() {


    var nationalities = arrayOf("Kenya","Rwandan","Sudan","Uganda")
    var nationalityAdapter = ArrayAdapter(baseContext,android.R.layout.simple_spinner_item,nationalities)
    nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    binding.spNationality.adapter =nationalityAdapter

}
//        btnregistration.setOnClickListener {
//            val name = etName.text.toString()
//            if (name.isEmpty()) {
//                etName.setError("name is required")
//            }
//
//            var dob = etDOB.text.toString()
//            var idNo = etIdNo.text.toString()
//            var nationality = ""
//            var Phone = etPhone.text.toString()
//            var email = etEmail.text.toString()
//
//            var student = Student(name, dob, idNo, nationality, Phone , email)
//            Toast.makeText(baseContext, student.toString(), Toast.LENGTH_LONG).show()
//        }
        fun clickRegistration() {
           binding.etButtonLBI.setOnClickListener {

                var name = binding.etName.text.toString()
                var dob = binding.etDOB.text.toString()
                var idNo = binding.etPassword.text.toString()
                var nationality = binding.spNationality.selectedItem.toString()
                var phone = binding.etPhoneNumber.text.toString()
                var email = binding.etEmail.text.toString()
                var password = binding.etPassword.text.toString()

          if (!Error){
              binding.pdregistration.visibility = View.VISIBLE
              var regRequest =RegistrationRequest(
                  name = name,
                  phoneNumber = phone,
                  email = email,
                  dateOfBirth = dob,
                  nationality = nationality.toUpperCase(),
                  password = password
              )
              var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
              var request = retrofit.registerStudent(regRequest)
              request.enqueue(object::Callback<RegistrationRequest>{
                  override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>){
                      binding.pdregistration.visibility = View.GONE
                      if (response.isSuccessful){
                          Toast.makeText(baseContext, "RegistrationResponse", Toast.LENGTH_SHORT).show()
                      }
                      else{
                          Toast.makeText(baseContext, response.errorBody()?, Toast.LENGTH_SHORT).show()
                      }
                  }
                  override fun onFailure(call: Call<RegistrationResponse, t:Throwable>){
                  Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
                  binding.pdregistration.visibility = View.GONE
              }
              })
                  
             
          }
            }

        }
    }



