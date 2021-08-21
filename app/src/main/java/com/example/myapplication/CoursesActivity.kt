package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoursesActivity : AppCompatActivity() {
    lateinit var rvCourses: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        displayCourses()
       }
    fun displayCourses(){
        var coursesList = listOf<Courses>(
            Courses("Android","AND 101", "Native android development","John Owuor"),
        Courses("Python", "PY 101","Backend development with python","Mwai"),
        Courses("Javascript","JS 101", "Javascript for web","Purity"),
        Courses("IOT","IOT 101", "IOT for conectivity in the 21st centuary","Barre"),
        )
        rvCourses = findViewById(R.id.rvcourses)
        var coursesAdapter = coursesRVAdapter(coursesList)
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        rvCourses.adapter = coursesAdapter
    }

    }