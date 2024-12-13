package com.example.weatherapp.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val baseUrl = "https://api.openweathermap.org/"

    private var client: OkHttpClient? = null

    private fun getOkHttpCLient(): OkHttpClient {
        if (client == null) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        }

        return client!!
    }

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getOkHttpCLient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val weatherApi : AppServices = getInstance().create(AppServices::class.java)
}
