package com.example.weatherapp.features.home

import androidx.activity.viewModels
import com.example.weatherapp.core.base.view.BaseActivity
import com.example.weatherapp.databinding.ActivityLocationBinding

class HomeActivity : BaseActivity<ActivityLocationBinding, HomeViewModel>(
    ActivityLocationBinding::inflate
) {

    override val viewModel: HomeViewModel by viewModels()

    override fun onInitView() {
        viewModel.getCurrentWeatherData()
        viewModel.getFiveDaysWeatherData()

    }

    override fun onInitListener() {
        binding.mapmarker.setOnClickListener {

        }
    }

    override fun onObserveData() {
        super.onObserveData()
        viewModel.currentWeatherResponseData.observe(this) { data ->
            val cityName = data.name ?: ""
            val countryCode = data.sys?.country ?: ""

            binding.textView18.text = "$cityName, $countryCode"
        }
    }
}

