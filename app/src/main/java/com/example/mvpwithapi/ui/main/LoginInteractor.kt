package com.example.mvpwithapi.ui.main

import com.example.mvpwithapi.base.interactor.BaseInteractor
import com.example.mvpwithapi.data.model.User
import com.example.mvpwithapi.data.network.ApiHelper
import com.example.mvpwithapi.data.prefs.PreferencesHelper
import io.reactivex.Observable
import javax.inject.Inject

class LoginInteractor @Inject constructor(
    mApiHelper: ApiHelper,
    mPreferencesHelper: PreferencesHelper
) : BaseInteractor(mApiHelper, mPreferencesHelper), LoginContract.Interactor {

    override fun doLogin(): Observable<User?> {
        return mApiHelper.loginUser()
    }

}