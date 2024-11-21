package com.example.weatherapp.features.login.repository

interface LoginRepository {

    suspend fun login(userName: String, password: String)

}