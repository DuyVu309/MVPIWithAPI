package com.example.mvpwithapi.ui.main

import com.example.mvpwithapi.base.presenter.BasePresenter
import com.example.mvpwithapi.utils.rx.ScheduleProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginPresenter
@Inject
constructor(
    mLoginInteractor: LoginInteractor,
    mScheduleProvider: ScheduleProvider,
    mCompositeDisposable: CompositeDisposable) : BasePresenter<LoginContract.View, LoginInteractor>(mLoginInteractor, mScheduleProvider, mCompositeDisposable), LoginContract.Presenter {

    override fun login() {
        getView().showLoading()
        mCompositeDisposable.add(
            mInteractor.doLogin()
                .compose(mScheduleProvider.ioToMainObservableScheduler())
                .subscribe({
                    getView().loginSuccess(it.toString())
                    getView().hideLoading()
                }, {
                    getView().loginError()
                    getView().handleError(null, it)
                    getView().hideLoading()
                })
        )
    }
}