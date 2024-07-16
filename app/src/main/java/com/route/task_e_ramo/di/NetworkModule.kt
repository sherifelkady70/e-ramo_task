package com.route.task_e_ramo.di

import android.util.Log
import com.route.task_e_ramo.api.Constants
import com.route.task_e_ramo.api.WebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideLoggingInterceptor() : HttpLoggingInterceptor {
        return HttpLoggingInterceptor{
            Log.e("API",it)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
    @Provides
    fun provideOkHttpClint(loggingInterceptor: HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient
            .Builder()
            .addNetworkInterceptor(loggingInterceptor)
            .build()
    }
    @Provides
    fun provideGson(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
    @Provides
    fun provideRetrofit(gson: GsonConverterFactory,
                        clint: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(gson)
            .client(clint)
            .build()
    }
    @Provides
    fun provideWebService(retrofit: Retrofit)  : WebService{
        return retrofit.create(WebService::class.java)
    }

}