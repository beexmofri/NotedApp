package com.example.roomapp.di.koin.dagger

import com.example.roomapp.viewmodel.UserViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(userViewModel: UserViewModel)
}