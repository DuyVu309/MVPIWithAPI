package com.example.mvpwithapi.base.interactor

import com.example.mvpwithapi.data.network.ApiHelper
import com.example.mvpwithapi.data.prefs.PreferencesHelper

abstract class BaseInteractor
constructor(protected val mApiHelper: ApiHelper,
            protected val mPreferences: PreferencesHelper
) : IBaseInteractor {

    override fun isUserLoggedIn(): Boolean {
        return mPreferences.getCurrentUser() != null
    }
}