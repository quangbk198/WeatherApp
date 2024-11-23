package com.example.weatherapp.features.login

import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels
import com.example.weatherapp.core.base.view.BaseActivity
import com.example.weatherapp.databinding.ActivityLoginBinding
import com.example.weatherapp.features.signup.SignupActivity

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

        binding.footertext.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
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