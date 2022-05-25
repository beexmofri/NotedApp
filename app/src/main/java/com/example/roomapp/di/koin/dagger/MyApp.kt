package com.example.roomapp.di.koin.dagger

import android.app.Application

class MyApp : Application(){

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun getAppComponent(): AppComponent{
        return appComponent
    }
}