package com.test.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    lateinit var  studentDAO: StudentDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = Room.databaseBuilder(this, AppDatabase::class.java, "student_db").build()

        CoroutineScope(Dispatchers.IO).launch {
            studentDAO = db.getStudentDAO()
            studentDAO.insert(Student(12, "bhakti", "android"))
            studentDAO.insert(Student(13, "geeta", "android"))
            studentDAO.insert(Student(14, "sakshi", "android"))

            var students = studentDAO.getAllStudents()
            for (eachStudent in students) {
                Log.e("tag", "${eachStudent.rollNumber}")
                Log.e("tag", eachStudent.name)
                Log.e("tag", eachStudent.technology)
            }

            studentDAO.delete(Student(12, "bhakti", "android"))
            students = studentDAO.getAllStudents()
            for (eachStudent in students) {
                Log.e("tag", "${eachStudent.rollNumber}")
                Log.e("tag", eachStudent.name)
                Log.e("tag", eachStudent.technology)
            }

            studentDAO.update(Student(13, "geeta", "android"))
            students = studentDAO.getAllStudents()
            for (eachStudent in students) {
                Log.e("tag", "${eachStudent.rollNumber}")
                Log.e("tag", eachStudent.name)
                Log.e("tag", eachStudent.technology)
            }
        }

        }
}