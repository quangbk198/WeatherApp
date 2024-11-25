package com.example.weatherapp.utils

import com.example.weatherapp.features.login.repository.LoginRepository
import com.example.weatherapp.features.login.repository.LoginRepositoryImpl
import com.example.weatherapp.features.signup.repository.SignupRepository
import com.example.weatherapp.features.signup.repository.SignupRepositoryImpl

object RepositoryFactory {

    fun getLoginRepository(): LoginRepository {
        return LoginRepositoryImpl()
    }

    fun getSignupRepository(): SignupRepository {
        return SignupRepositoryImpl()

    }

}