package com.example.d4aspostrecitos.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.d4aspostrecitos.data.local.entities.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity)

    @Query("SELECT * FROM users LIMIT 1")
    suspend fun getUser(): UserEntity?

    @Query("DELETE FROM users")
    suspend fun clear()
}