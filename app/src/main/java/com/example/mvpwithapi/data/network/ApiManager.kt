package com.example.mvpwithapi.data.network

import com.example.mvpwithapi.data.model.User
import com.example.mvpwithapi.di.anotation.retrofit.ApiRoute
import dagger.Module
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

@Module
class ApiManager
@Inject constructor(
    @ApiRoute retrofitApi: Retrofit
) : ApiHelper{

    private val mApiHelper = retrofitApi.create(ApiHelper::class.java)

    override fun loginUser(): Observable<User?> {
        return mApiHelper.loginUser()
    }

}