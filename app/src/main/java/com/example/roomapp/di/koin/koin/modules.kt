package com.example.roomapp.di.koin.koin

import com.example.roomapp.model.User
import com.example.roomapp.repository.UserRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule : Module = module{
   single {User(1, "judul", "hari kamis") }

    single {UserRepository(get()) }
}