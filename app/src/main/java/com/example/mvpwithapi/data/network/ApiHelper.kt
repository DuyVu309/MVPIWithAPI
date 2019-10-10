package com.example.mvpwithapi.data.network

import com.example.mvpwithapi.data.model.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiHelper{

    @GET("/todos/1")
    fun loginUser(): Observable<User?>
}