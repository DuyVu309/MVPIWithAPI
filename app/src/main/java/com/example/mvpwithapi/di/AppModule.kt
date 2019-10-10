package com.example.mvpwithapi.di

import android.app.Application
import android.content.Context
import com.example.mvpwithapi.BuildConfig
import com.example.mvpwithapi.data.exception.RxErrorHandlingCallAdapterFactory
import com.example.mvpwithapi.data.network.ApiHelper
import com.example.mvpwithapi.data.network.ApiManager
import com.example.mvpwithapi.data.network.HeadersInterceptor
import com.example.mvpwithapi.data.prefs.PreferencesHelper
import com.example.mvpwithapi.data.prefs.PreferencesManager
import com.example.mvpwithapi.di.anotation.Preference
import com.example.mvpwithapi.di.anotation.okhttp.ApiClient
import com.example.mvpwithapi.di.anotation.retrofit.ApiRoute
import com.example.mvpwithapi.di.anotation.retrofit.BaseUrl
import com.example.mvpwithapi.utils.AppConstants
import com.example.mvpwithapi.utils.rx.AppSchedulerProvider
import com.example.mvpwithapi.utils.rx.ScheduleProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Preference
    internal fun providePreferenceFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePreferenceHelper(appPreferences: PreferencesManager): PreferencesHelper = appPreferences

    @Provides
    @Singleton
    internal fun provideGson() = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

    @Provides
    @BaseUrl
    internal fun provideBaseUrl(): String = AppConstants.BASE_URL

    @Provides
    internal fun provideOkHttpCache(application: Application): Cache {
        val cacheDir = File(application.cacheDir, UUID.randomUUID().toString())
        return Cache(cacheDir, 10 * 1024 * 1024)
    }
    @Provides
    @Singleton
    @ApiClient
    internal fun provideOkHttpClientApi(cache: Cache, headersInterceptor: HeadersInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        return OkHttpClient.Builder()
            .cache(cache)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(headersInterceptor)
            .retryOnConnectionFailure(true)
            .build()
    }

    @Provides
    @Singleton
    @ApiRoute
    internal fun provideRetrofitApi(@BaseUrl baseUrl: String,
                                    gson: Gson,
                                    @ApiClient okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideApiHelper(apiManager: ApiManager): ApiHelper = apiManager

    @Provides
    internal fun provideScheduleProvider(): ScheduleProvider = AppSchedulerProvider()

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}