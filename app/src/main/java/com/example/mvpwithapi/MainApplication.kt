package com.example.mvpwithapi

import android.app.Activity
import android.app.Application
import com.example.mvpwithapi.di.AppComponent
import com.example.mvpwithapi.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MainApplication : Application(), HasActivityInjector {

    @Inject
    internal lateinit var mActivityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = mActivityDispatchingAndroidInjector

    lateinit var mAppComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        mAppComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        mAppComponent.inject(this)

    }


}