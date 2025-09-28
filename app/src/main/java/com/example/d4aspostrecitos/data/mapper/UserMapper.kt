package com.example.d4aspostrecitos.data.mapper

import com.example.d4aspostrecitos.data.local.entities.UserEntity
import com.example.d4aspostrecitos.data.remote.dto.UserDto
import com.example.d4aspostrecitos.domain.model.User

fun UserDto.toEntity() = UserEntity(
    id = id,
    username = username,
    nombres = nombres,
    apellidos = apellidos,
    correo = correo,
    role = role
)

// DTO → Domain
fun UserDto.toDomain() = User(
    id = id,
    username = username,
    nombres = nombres,
    apellidos = apellidos,
    correo = correo,
    role = role
)

// Entity → Domain
fun UserEntity.toDomain() = User(
    id = id,
    username = username,
    nombres = nombres,
    apellidos = apellidos,
    correo = correo,
    role = role
)