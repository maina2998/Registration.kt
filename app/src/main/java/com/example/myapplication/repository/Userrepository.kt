package com.example.myapplication.repository

import com.example.myapplication.API.ApiClient
import com.example.myapplication.API.ApiInterface
import com.example.myapplication.Models.LoginResponse
import com.example.myapplication.Models.RegistrationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import com.example.myapplication.Models.LoginRequest as LoginRequest1
import com.example.myapplication.Models.RegistrationRequest as RegistrationRequest1

class userrepository {
    var retrofit =ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun registerStudent(registrationRequest: RegistrationRequest1): Response<RegistrationResponse> =
        withContext(Dispatchers.IO){
            var response=retrofit.registerStudent()
            return@withContext response
        }
    suspend fun loginStudent(loginRequest: LoginRequest1): Response<LoginResponse> =
        withContext(Dispatchers.IO){
            var response=retrofit.logInstudent(loginRequest)
            return@withContext response
        }
}