package com.example.mvpwithapi.di

import com.example.mvpwithapi.ui.main.LoginActivity
import com.example.mvpwithapi.ui.main.LoginActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule{

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    abstract fun bindMainActivity(): LoginActivity

}