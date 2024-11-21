package com.example.weatherapp.core.base.view

interface IBehavior {

    fun onInitView()

    fun onInitListener()

    fun onObserveData()

    fun onLoading(isLoading: Boolean)

    fun onError(errMess: String?)

}