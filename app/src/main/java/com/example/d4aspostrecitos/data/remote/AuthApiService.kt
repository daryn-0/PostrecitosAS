package com.example.d4aspostrecitos.data.remote

import com.example.d4aspostrecitos.data.remote.dto.AuthResponseDto
import com.example.d4aspostrecitos.data.remote.dto.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("api/v1/auth/login")
    suspend fun login(@Body body: LoginRequest): AuthResponseDto
}