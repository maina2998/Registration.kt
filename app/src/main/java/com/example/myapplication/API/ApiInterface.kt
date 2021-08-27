package com.example.myapplication.API

import com.example.myapplication.Models.LoginRequest
import com.example.myapplication.Models.LoginResponse
import com.example.myapplication.Models.RegistrationRequest
import com.example.myapplication.Models.RegistrationResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    suspend fun registerStudent(@Body registrationRequest: RegistrationRequest): Response<RegistrationResponse>


    @POST("students/login")
    suspend fun logInstudent(@Body LoginRequest:LoginRequest ):Response<LoginResponse>

}


