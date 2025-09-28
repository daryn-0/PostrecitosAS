package com.example.d4aspostrecitos.data.remote.dto

data class AuthResponseDto(
    val accessToken: String,
    val refreshToken: String,
    val user: UserDto
)