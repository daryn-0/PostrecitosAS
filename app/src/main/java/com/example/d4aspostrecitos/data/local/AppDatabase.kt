package com.example.d4aspostrecitos.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.d4aspostrecitos.data.local.dao.UserDao
import com.example.d4aspostrecitos.data.local.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}