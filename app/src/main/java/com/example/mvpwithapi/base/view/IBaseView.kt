package com.example.mvpwithapi.base.view

interface IBaseView{
    fun showLoading()

    fun hideLoading()

    fun handleError(errorCode: Int?, throwable: Throwable?)
}