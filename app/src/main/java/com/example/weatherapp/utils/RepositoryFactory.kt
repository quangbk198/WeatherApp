package com.example.weatherapp.utils

import com.example.weatherapp.features.login.repository.LoginRepository
import com.example.weatherapp.features.login.repository.LoginRepositoryImpl

object RepositoryFactory {

    fun getLoginRepository(): LoginRepository {
        return LoginRepositoryImpl()
    }

}