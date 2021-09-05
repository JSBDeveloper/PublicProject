package com.project.publicproject.di

import android.app.Application
import com.project.publicproject.BaseApplication
import com.project.publicproject.di.module.ContextModule
import com.project.publicproject.di.module.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    RetrofitModule::class, ContextModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application) : AppComponent
    }
}