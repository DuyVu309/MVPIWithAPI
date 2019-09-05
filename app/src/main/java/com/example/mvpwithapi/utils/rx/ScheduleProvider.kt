package com.example.mvpwithapi.utils.rx

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler

interface ScheduleProvider {
    fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T>

    fun io(): Scheduler

    fun ui(): Scheduler
}