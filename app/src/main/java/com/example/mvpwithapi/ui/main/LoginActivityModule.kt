package com.example.mvpwithapi.ui.main

import dagger.Binds
import dagger.Module

@Module
abstract class LoginActivityModule {

    @Binds
    abstract fun bindTrainingExercisePresenter(presenter: LoginPresenter): LoginContract.Presenter

    @Binds
    abstract fun bindTrainingExerciseInteractor(interactor: LoginInteractor): LoginContract.Interactor
}