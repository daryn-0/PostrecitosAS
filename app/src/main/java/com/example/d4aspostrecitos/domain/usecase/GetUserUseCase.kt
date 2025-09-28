package com.example.d4aspostrecitos.domain.usecase

import com.example.d4aspostrecitos.domain.repository.AuthRepository

class GetUserUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke() = repository.getUser()
}