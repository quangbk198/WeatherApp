package com.example.weatherapp.features.signup

import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels
import com.example.weatherapp.core.base.view.BaseActivity
import com.example.weatherapp.databinding.ActivitySignupBinding
import com.example.weatherapp.features.login.LoginActivity

class SignupActivity : BaseActivity<ActivitySignupBinding, SignupViewModel>(
    ActivitySignupBinding::inflate
) {

    override val viewModel: SignupViewModel by viewModels()

    override fun onInitView() {

    }

    override fun onInitListener() {
        binding.btnSignup.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val phoneText = binding.etPhone.text.toString().trim()

            // Validate input fields
            if (username.isEmpty()) {
                binding.etUsername.error = "Username is required"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.etPassword.error = "Password is required"
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                binding.etEmail.error = "Email is required"
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail.error = "Invalid email format"
                return@setOnClickListener
            }

            if (phoneText.isEmpty()) {
                binding.etPhone.error = "Phone number is required"
                return@setOnClickListener
            }

            val phone = phoneText.toLongOrNull()
            if (phone == null || phone <= 0) {
                binding.etPhone.error = "Invalid phone number"
                return@setOnClickListener
            }

            // Pass data to ViewModel for processing
            viewModel.signup(username, password, email, phone)
        }
    }

    override fun onObserveData() {
        super.onObserveData()

        viewModel.signupState.observe(this) { success ->
            if (success) {
                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show()
                // Navigate back to LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish() // Close SignupActivity
            } else {
                Toast.makeText(this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
