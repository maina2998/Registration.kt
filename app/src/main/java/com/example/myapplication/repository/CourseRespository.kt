package com.example.myapplication.repository

import com.example.myapplication.API.ApiClient
import com.example.myapplication.API.ApiInterface
import com.example.myapplication.Courses
import com.example.myapplication.Models.Course
import com.example.myapplication.Models.EnrollmentResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CourseRespository {
    var retrofit= ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun fetchCourse(accessToken:String):Response<List<Courses>> =
        withContext(Dispatchers.IO){
            return@withContext retrofit.fetchCourses(accessToken)
        }
    suspend fun enrol(accessToken: String): Response<EnrollmentResponse> =
        withContext(Dispatchers.IO){
            var enrol =ApiInterface.enrol(accessToken)
            return@withContext enrol

}}