package com.test.roomdemo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract  fun  getStudentDAO(): StudentDAO


}