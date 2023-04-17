package com.test.roomdemo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDAO {
    @Query("select * from students")
    fun getAllStudents(): List<Student>

    @Insert
    fun insert(student: Student)

    @Delete
    fun delete(student: Student)

    @Update
    fun update(student: Student)
}