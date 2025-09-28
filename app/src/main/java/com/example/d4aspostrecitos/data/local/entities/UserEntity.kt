package com.example.d4aspostrecitos.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Int,
    val username: String,
    val nombres: String,
    val apellidos: String,
    val correo: String,
    val role: String
)