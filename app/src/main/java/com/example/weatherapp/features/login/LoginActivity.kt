package com.example.weatherapp.features.login

import android.widget.Toast
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
        binding.btnLogin.setOnClickListener {
            viewModel.login("", "")
        }
    }

    override fun onObserveData() {
        super.onObserveData()

        viewModel.loginState.observe(this) { success ->
            if (success) {
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show()
            }
        }
    }
}