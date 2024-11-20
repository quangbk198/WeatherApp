package com.example.weatherapp.features.login

import androidx.activity.viewModels
import com.example.weatherapp.core.base.view.BaseActivity
import com.example.weatherapp.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(
    ActivityLoginBinding::inflate
) {

    override val viewModel: LoginViewModel by viewModels()

    override fun onInitView() {

    }

    override fun onInitListener() {

    }
}