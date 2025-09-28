package com.example.d4aspostrecitos.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.d4aspostrecitos.domain.model.AuthTokens

class SharedPrefsManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_ACCESS_TOKEN = "access_token"
        private const val KEY_REFRESH_TOKEN = "refresh_token"
    }

    fun saveAuthTokens(tokens: AuthTokens) {
        prefs.edit().apply {
            putString(KEY_ACCESS_TOKEN, tokens.accessToken)
            putString(KEY_REFRESH_TOKEN, tokens.refreshToken)
            apply()
        }
    }

    fun getAuthTokens(): AuthTokens? {
        val access = prefs.getString(KEY_ACCESS_TOKEN, null) ?: return null
        val refresh = prefs.getString(KEY_REFRESH_TOKEN, null) ?: return null
        return AuthTokens(access, refresh)
    }

    fun clearTokens() {
        prefs.edit().clear().apply()
    }
}