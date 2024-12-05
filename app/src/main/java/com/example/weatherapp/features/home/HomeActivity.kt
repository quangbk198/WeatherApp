package com.example.weatherapp.features.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.weatherapp.core.base.view.BaseActivity
import com.example.weatherapp.databinding.ActivityHomeBinding
import com.example.weatherapp.data.remote.response.NetworkResponse

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(
    ActivityHomeBinding::inflate
) {

    override val viewModel: HomeViewModel by viewModels()

    override fun onInitView() {
    }

    override fun onInitListener() {
        binding.searchButton.setOnClickListener {
            val cityName = binding.searchEditText.text.toString().trim()
            if (cityName.isNotEmpty()) {
                // Call the ViewModel function to fetch weather data for the entered city
                viewModel.getData(cityName)
            } else {
                Toast.makeText(this, "Please enter a city name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onObserveData() {
        super.onObserveData()

        // Observing the weather result to update the UI
        viewModel.weatherResult.observe(this, Observer { response ->
            when (response) {
                is NetworkResponse.Success -> {
                    // Update the UI with the weather data
                    val weatherData = response.data
                    binding.weatherResultText.text = "Weather in ${weatherData.name}: ${weatherData.main.temp}°C"
                }
                is NetworkResponse.Error -> {
                    // Show error message
                    Toast.makeText(this, "Error: ${response.message}", Toast.LENGTH_SHORT).show()
                }
                NetworkResponse.Loading -> {
                    // Show loading state (if needed)
                    binding.weatherResultText.text = "Loading..."
                }
            }
        })
    }
}
