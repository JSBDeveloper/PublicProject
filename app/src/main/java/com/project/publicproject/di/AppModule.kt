package com.project.publicproject.di

import com.project.publicproject.retrofit.RetrofitService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideRetrofitService(
        okHttpClient: OkHttpClient,
        factory: Converter.Factory
    ): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(factory)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
            .create(RetrofitService::class.java)
    }
}