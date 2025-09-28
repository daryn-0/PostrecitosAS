package com.example.d4aspostrecitos.domain.repository

import com.example.d4aspostrecitos.domain.model.AuthTokens
import com.example.d4aspostrecitos.domain.model.User

interface AuthRepository {
    suspend fun login(username: String, password: String): User
    suspend fun getUser(): User?
    suspend fun getAuthTokens(): AuthTokens?
    suspend fun logout()
}