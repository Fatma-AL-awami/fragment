package com.example.fragment

import androidx.lifecycle.ViewModel

class model: ViewModel()

{
    val students = mutableListOf<student>()
    init {
        for (i in 0 until 100) {
            val stu = student()
            stu.name="student + $i"
             stu.number= i
            stu.pass=i % 2==0
            students += students
        }
    }

}


