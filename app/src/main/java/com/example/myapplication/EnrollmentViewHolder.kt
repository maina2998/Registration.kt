package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Models.EnrollmentResponse
import com.example.myapplication.repository.CourseRespository
import kotlinx.coroutines.launch

class EnrollmentViewHolder:ViewModel() {

        var enrolmentLiveData= MutableLiveData<EnrollmentResponse>()
        var errorLiveData= MutableLiveData<String>()
        var courseRepository =CourseRespository()

        fun enrol(accesToken:String){
            viewModelScope.launch {
                var response= courseRepository.enrol(accesToken)
                if(response.isSuccessful){
                    enrolmentLiveData.postValue(response.body())
                }else{errorLiveData.postValue(response.errorBody()?.string())}
            }
        }
    }
