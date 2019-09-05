package com.example.mvpwithapi.data.prefs

import com.example.mvpwithapi.data.model.User

interface PreferencesHelper{

    fun getAccessToken(): String?

    fun setAccessToken(accessToken: String?)

    fun getCurrentUser(): User?

    fun setCurrentUser(user: User?)
}