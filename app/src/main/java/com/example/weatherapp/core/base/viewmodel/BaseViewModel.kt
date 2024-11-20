package com.example.weatherapp.core.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val _loadingState: MutableLiveData<Boolean> by lazy { MutableLiveData() }
    val loadingState: LiveData<Boolean> get() = _loadingState

    private val _errorState: MutableLiveData<String> by lazy { MutableLiveData() }
    val errorState: LiveData<String> get() = _errorState

    fun setLoading(isLoading: Boolean) {
        _loadingState.postValue(isLoading)
    }

    fun setError(errMess: String) {
        _errorState.postValue(errMess)
    }
}