package com.example.d4aspostrecitos.domain.model

data class User(
    val id: Int,
    val nombres: String,
    val apellidos: String,
    val correo: String,
    val username: String,
    val role: String
)