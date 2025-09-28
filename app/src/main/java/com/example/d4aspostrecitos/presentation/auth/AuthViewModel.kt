package com.example.d4aspostrecitos.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.d4aspostrecitos.domain.model.User
import com.example.d4aspostrecitos.domain.usecase.GetUserUseCase
import com.example.d4aspostrecitos.domain.usecase.LoginUseCase
import com.example.d4aspostrecitos.domain.usecase.LogoutUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val loginUseCase: LoginUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> get() = _user

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _loading.value = true
            try {
                val result = loginUseCase(username, password)
                _user.value = result
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }

    fun loadUser() {
        viewModelScope.launch {
            _user.value = getUserUseCase()
        }
    }

    fun logout() {
        viewModelScope.launch {
            logoutUseCase()
            _user.value = null
        }
    }
}