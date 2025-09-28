package com.example.d4aspostrecitos.data.mapper

import com.example.d4aspostrecitos.data.local.entities.UserEntity
import com.example.d4aspostrecitos.data.remote.dto.AuthResponseDto
import com.example.d4aspostrecitos.domain.model.AuthTokens
import com.example.d4aspostrecitos.domain.model.User

// AuthResponseDto → Domain User
fun AuthResponseDto.toUserDomain(): User = user.toDomain()

// AuthResponseDto → Room UserEntity
fun AuthResponseDto.toUserEntity(): UserEntity = user.toEntity()

// AuthResponseDto → Domain AuthTokens
fun AuthResponseDto.toAuthTokens(): AuthTokens =
    AuthTokens(accessToken = accessToken, refreshToken = refreshToken)