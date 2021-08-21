package com.example.myapplication.API

import com.example.myapplication.Models.RegistrationRequest
import com.example.myapplication.Models.RegistrationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    fun registerStudent(@Body registrationRequest: RegistrationRequest): Call<RegistrationResponse>
}