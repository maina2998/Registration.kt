package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class coursesRVAdapter (var courseList: List<Courses>):RecyclerView.Adapter<CoursesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
  var itemView = LayoutInflater.from(parent.context).inflate(R.layout.course_list_item,parent,
  false)

        return CoursesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
       var currentCourse=courseList.get(position)
        holder.tvCourseName.text=currentCourse.courseName
        holder.tvdescription.text=currentCourse.description
        holder.tvCourseCode.text=currentCourse.courseCode
        holder.tvinstructor.text=currentCourse.instructor

    }

    override fun getItemCount(): Int {
    return  courseList.size
    }
}
class CoursesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvCourseName = itemView.findViewById<TextView>(R.id.tvcourseName)
    var tvdescription = itemView.findViewById<TextView>(R.id.tvdescription)
    var tvCourseCode= itemView.findViewById<TextView>(R.id.tvandroid101)
    var tvinstructor= itemView.findViewById<TextView>(R.id.tvinstructor)
}