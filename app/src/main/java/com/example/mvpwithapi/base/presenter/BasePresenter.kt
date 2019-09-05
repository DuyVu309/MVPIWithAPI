package com.example.mvpwithapi.base.presenter

import com.example.mvpwithapi.base.interactor.IBaseInteractor
import com.example.mvpwithapi.base.view.IBaseView
import com.example.mvpwithapi.utils.rx.ScheduleProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V : IBaseView, out I : IBaseInteractor>
constructor(
    protected val mInteractor: I,
    protected val mScheduleProvider: ScheduleProvider,
    protected val mCompositeDisposable: CompositeDisposable
){
    protected lateinit var mBaseView: V

    fun onAttach(view: V) {
        mBaseView = view
    }

    fun onDetach() {
        mCompositeDisposable.dispose()
    }

    protected fun getView(): V = mBaseView
}