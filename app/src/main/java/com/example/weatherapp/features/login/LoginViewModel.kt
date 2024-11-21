package com.example.weatherapp.features.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.core.base.viewmodel.BaseViewModel
import com.example.weatherapp.utils.RepositoryFactory
import kotlinx.coroutines.launch

class LoginViewModel : BaseViewModel() {

    private val _loginState: MutableLiveData<Boolean> by lazy { MutableLiveData() }
    val loginState: LiveData<Boolean> get() = _loginState

    fun login(
        userName: String,
        password: String
    ) {
        coroutineScope.launch {
            setLoading(true)
            RepositoryFactory.getLoginRepository().login(userName, password)
            _loginState.value = true
            setLoading(false)
        }
    }

}