package com.project.publicproject

import android.app.Application
import android.content.Context
import com.project.publicproject.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class BaseApplication : Application(), HasAndroidInjector {
    companion object {
        lateinit var context: Context
    }

    @Inject
    lateinit var activityDispatchingInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        context = this

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun androidInjector() = activityDispatchingInjector
}