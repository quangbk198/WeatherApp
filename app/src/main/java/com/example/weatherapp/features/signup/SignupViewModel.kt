package com.example.weatherapp.features.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.core.base.viewmodel.BaseViewModel
import com.example.weatherapp.features.signup.repository.SignupRepository
import com.example.weatherapp.utils.RepositoryFactory
import kotlinx.coroutines.launch

class SignupViewModel : BaseViewModel() {

    private val _signupState: MutableLiveData<Boolean> by lazy { MutableLiveData() }
    val signupState: LiveData<Boolean> get() = _signupState

    fun signup(username: String, password: String, email: String, phone: Long) {
        coroutineScope.launch {
            setLoading(true)

            RepositoryFactory.getSignupRepository()
                .signup(username, password, email, phone)

            setLoading(false)
            _signupState.value = true
        }
    }
}
