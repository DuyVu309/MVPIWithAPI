package com.example.mvpwithapi.data.prefs

import android.content.Context
import com.example.mvpwithapi.data.model.User
import com.example.mvpwithapi.di.anotation.Preference
import com.example.mvpwithapi.utils.extension.edit
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager
@Inject constructor(
    context: Context,
    @Preference private val prefFileName: String
) : PreferencesHelper{
    companion object {
        private const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        private const val PREF_KEY_CURRENT_USER = "PREF_KEY_CURRENT_USER"
    }

    private val mPreference = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getAccessToken(): String? {
        return mPreference.getString(PREF_KEY_ACCESS_TOKEN, null)
    }

    override fun setAccessToken(accessToken: String?) {
        mPreference.edit { putString(PREF_KEY_ACCESS_TOKEN, accessToken) }
    }

    override fun getCurrentUser(): User? {
        return Gson().fromJson(mPreference.getString(PREF_KEY_CURRENT_USER, null), User::class.java)
    }

    override fun setCurrentUser(user: User?) {
        val json = Gson().toJson(user)
        mPreference.edit { putString(PREF_KEY_CURRENT_USER, json) }
    }
}