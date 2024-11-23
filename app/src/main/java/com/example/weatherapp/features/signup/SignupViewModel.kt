package com.example.weatherapp.features.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.core.base.viewmodel.BaseViewModel

class SignupViewModel : BaseViewModel() {

    private val _signupState = MutableLiveData<Boolean>()
    val signupState: LiveData<Boolean> get() = _signupState

    fun signup(username: String, password: String, email: String, phone: Long?) {
        // Simulate a signup process. Replace this with actual logic.
        if (username.isNotEmpty() && password.isNotEmpty() && email.isNotEmpty() && phone != null && phone>0) {
            _signupState.value = true // Success
        } else {
            _signupState.value = false // Failure
        }
    }
}
