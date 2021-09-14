package com.example.myapplication.API

import com.example.myapplication.Courses
import com.example.myapplication.Models.EnrollmentResponse
import com.example.myapplication.Models.LoginRequest
import com.example.myapplication.Models.LoginResponse
import com.example.myapplication.Models.RegistrationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    suspend fun registerStudent(@Body registrationRequest: LoginRequest): Response<RegistrationResponse>


    @POST("students/login")
    suspend fun logInstudent(@Body LoginRequest:LoginRequest ):Response<LoginResponse>
    abstract fun registerStudent(): Response<RegistrationResponse>

    @GET("/courses")
    suspend fun fetchCourses(@Header("Authorization")token:String):Response<List<Courses>>

    @POST("/enrolments")
    suspend fun enrol(@Header("Authorization")token: String):Response<EnrollmentResponse>
}



