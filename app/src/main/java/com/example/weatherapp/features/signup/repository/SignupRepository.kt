package com.example.weatherapp.features.signup.repository

interface SignupRepository {
    suspend fun signup(username: String, password: String, email: String, phone: Long)
}
