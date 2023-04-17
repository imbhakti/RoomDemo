package com.test.roomdemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(

  @PrimaryKey @ColumnInfo(name ="rollNumber")  var rollNumber: Int,
    var name: String,
    var technology: String
)
