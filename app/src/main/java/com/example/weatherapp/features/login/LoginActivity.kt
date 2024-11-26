package com.example.weatherapp.features.login

import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels
import com.example.weatherapp.R
import com.example.weatherapp.core.base.view.BaseActivity
import com.example.weatherapp.databinding.ActivityLoginBinding
import com.example.weatherapp.features.home.HomeActivity
import com.example.weatherapp.features.signup.SignupActivity

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(
    ActivityLoginBinding::inflate
) {

    override val viewModel: LoginViewModel by viewModels()

    override fun onInitView() {

    }

    override fun onInitListener() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.email.error = getString(R.string.error_email_required)
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.pword.error = getString(R.string.error_password_required)
                return@setOnClickListener
            }

            viewModel.login(email, password)
        }

        binding.footertext.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }



    override fun onObserveData() {
        super.onObserveData()

        viewModel.loginState.observe(this) { success ->
            if (success) {
                Toast.makeText(this, getString(R.string.toast_login_successful), Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, getString(R.string.toast_login_unsuccessful), Toast.LENGTH_SHORT).show()
            }
        }
    }
}