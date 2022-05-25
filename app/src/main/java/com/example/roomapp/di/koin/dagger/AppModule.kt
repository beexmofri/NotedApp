package com.example.roomapp.di.koin.dagger

import android.app.Application
import android.content.Context
import com.example.roomapp.data.UserDao
import com.example.roomapp.data.UserDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Singleton
    @Provides
    fun getUserDao(userDatabase: UserDatabase): UserDao{
        return userDatabase.userDao()
    }

    @Singleton
    @Provides
    fun getRoomDB(): UserDatabase{
        return UserDatabase.getDatabase(provideUserContext())
    }

    @Singleton
    @Provides
    fun provideUserContext(): Context{
        return application.applicationContext
    }
}