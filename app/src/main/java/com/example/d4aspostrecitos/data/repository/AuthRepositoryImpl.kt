package com.example.d4aspostrecitos.data.repository

import com.example.d4aspostrecitos.data.local.SharedPrefsManager
import com.example.d4aspostrecitos.data.local.dao.UserDao
import com.example.d4aspostrecitos.data.mapper.toAuthTokens
import com.example.d4aspostrecitos.data.mapper.toDomain
import com.example.d4aspostrecitos.data.mapper.toUserDomain
import com.example.d4aspostrecitos.data.mapper.toUserEntity
import com.example.d4aspostrecitos.data.remote.AuthApiService
import com.example.d4aspostrecitos.data.remote.dto.LoginRequest
import com.example.d4aspostrecitos.domain.model.AuthTokens
import com.example.d4aspostrecitos.domain.model.User
import com.example.d4aspostrecitos.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val api: AuthApiService,
    private val userDao: UserDao,
    private val prefs: SharedPrefsManager
) : AuthRepository {

    override suspend fun login(username: String, password: String): User {
        // Creamos el DTO que la API espera
        val request = LoginRequest(username = username, password = password)

        // Llamamos a la API
        val response = api.login(request)

        // Guardamos usuario en Room
        userDao.insert(response.toUserEntity())

        // Guardamos tokens en SharedPreferences
        prefs.saveAuthTokens(response.toAuthTokens())

        // Devolvemos User para dominio / ViewModel
        return response.toUserDomain()
    }

    override suspend fun getUser(): User? {
        return userDao.getUser()?.toDomain()
    }

    override suspend fun getAuthTokens(): AuthTokens? {
        return prefs.getAuthTokens()
    }

    override suspend fun logout() {
        userDao.clear()
        prefs.clearTokens()
    }
}