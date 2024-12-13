package com.example.weatherapp.features.home

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.weatherapp.core.base.view.BaseActivity
import com.example.weatherapp.databinding.ActivityLocationBinding
import com.example.weatherapp.utils.Constants.LOCATION_PERMISSION_REQUEST_CODE
import com.google.android.gms.location.FusedLocationProviderClient

class HomeActivity : BaseActivity<ActivityLocationBinding, HomeViewModel>(
    ActivityLocationBinding::inflate
) {

    override val viewModel: HomeViewModel by viewModels()
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onInitView() {
        // Kiểm tra quyền truy cập vị trí
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // permission is pass get the location
            viewModel.fetchCurrentWeather(fusedLocationClient)
        } else {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }
    }


    override fun onInitListener() {
        binding.mapmarker.setOnClickListener {

        }
    }

    override fun onObserveData() {
        super.onObserveData()


        viewModel.currentWeatherResponseData.observe(this) { data ->
            if (data != null) {
                val cityName = data.name ?: "Unknown City"
                val countryCode = data.sys?.country ?: "Unknown Country"

                binding.textView18.text = "$cityName, $countryCode"
            } else {
                binding.textView18.text = "Error."
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                viewModel.fetchCurrentWeather(fusedLocationClient)
            } else {
                binding.textView18.text = "Error!"
            }
        }
    }

}

