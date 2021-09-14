package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Models.Course
import com.example.myapplication.repository.CourseRespository

class CourseViewModel {
    var CourseRespository = CourseRespository()
    var coursesLiveData = MutableLiveData<List<Course>>()
    var errorLiveData = MutableLiveData<List<Course>>()

    fun getCourses(accessToken:String)
}