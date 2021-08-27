package com.example.myapplication.repository

import com.example.myapplication.API.ApiClient
import com.example.myapplication.API.ApiInterface
import com.example.myapplication.Models.LoginRequest
import com.example.myapplication.Models.RegistrationRequest
import com.example.myapplication.Models.RegistrationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class Userrepository {
    var retrofit =ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun registerStudent(registrationRequest: RegistrationRequest): Response<RegistrationResponse> =
        withContext(Dispatchers.IO){
            var response=retrofit.registerStudent(registrationRequest)
            return@withContext response
        }
    suspend fun loginStudent(registrationRequest: LoginRequest): Response<RegistrationResponse> =
        withContext(Dispatchers.IO){
            var response=retrofit.registerStudent(registrationRequest)
            return@withContext response
        }
}