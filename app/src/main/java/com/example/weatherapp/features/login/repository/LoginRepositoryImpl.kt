package com.example.weatherapp.features.login.repository

import kotlinx.coroutines.delay

class LoginRepositoryImpl : LoginRepository {

    override suspend fun login(userName: String, password: String) {
        delay(3000)
        throw NullPointerException()
    }
}