package com.example.weatherapp.features.login.repository

interface LoginRepository {

    suspend fun login(email: String, password: String)

}