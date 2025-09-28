package com.example.d4aspostrecitos.data.remote.dto

data class UserDto(
    val id: Int,
    val username: String,
    val nombres: String,
    val apellidos: String,
    val correo: String,
    val role: String
)