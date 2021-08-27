package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Models.LoginRequest
import com.example.myapplication.Models.LoginResponse
import com.example.myapplication.Models.RegistrationRequest
import com.example.myapplication.Models.RegistrationResponse
import com.example.myapplication.repository.Userrepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val Userrepository = Userrepository()
    var registrationLiveData = MutableLiveData<RegistrationResponse>()
    var errorLiveData = MutableLiveData<String>()
    var loginLiveData = MutableLiveData<LoginResponse>()

    fun registerStudent(registrationRequest: RegistrationRequest) {
        viewModelScope.launch {
            var response = Userrepository.registerStudent(registrationRequest)
            if (response.isSuccessful) {
                registrationLiveData.postValue(response.body())
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
   fun loginStudent(loginRequest: LoginRequest){
       viewModelScope.launch { 
           val response =Userrepository.loginStudent(loginRequest)
           if (response.isSuccessful){
               loginLiveData.postValue(response.body())
           }
           else{
               errorLiveData.postValue(response.errorBody()?.string())
           }
       }
   }


}

private fun <T> MutableLiveData<T>.postValue(body: RegistrationResponse?) {

}
