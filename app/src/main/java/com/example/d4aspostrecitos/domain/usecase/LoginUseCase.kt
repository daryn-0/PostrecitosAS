package com.example.d4aspostrecitos.domain.usecase

import com.example.d4aspostrecitos.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(username: String, password: String) = repository.login(username, password)
}