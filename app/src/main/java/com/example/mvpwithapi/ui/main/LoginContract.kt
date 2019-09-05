package com.example.mvpwithapi.ui.main

import com.example.mvpwithapi.base.interactor.IBaseInteractor
import com.example.mvpwithapi.base.view.IBaseView
import com.example.mvpwithapi.data.model.User
import io.reactivex.Observable

class LoginContract{
    interface View : IBaseView{
        fun loginSuccess()

        fun loginError()
    }

    interface Presenter {
        fun login()
    }

    interface Interactor : IBaseInteractor{
        fun doLogin() : Observable<User?>
    }
}