package com.example.mvpwithapi.data.network

import com.example.mvpwithapi.data.model.User
import io.reactivex.Observable
import retrofit2.http.POST

interface ApiHelper{

    @POST("/user/.json")
    fun loginUser(): Observable<User?>
}