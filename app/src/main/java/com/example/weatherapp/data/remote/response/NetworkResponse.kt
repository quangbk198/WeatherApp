package com.example.weatherapp.data.remote.response

// Sealed class to represent different network response states
sealed class NetworkResponse<out T> {

    // Success state with the response data (T could be your data class, like WeatherResponse)
    data class Success<out T>(val data: T) : NetworkResponse<T>()

    // Error state with the error message and code
    data class Error(val message: String, val code: Int? = null) : NetworkResponse<Nothing>()

    // Loading state for managing the loading state of the API request
    object Loading : NetworkResponse<Nothing>()
}
