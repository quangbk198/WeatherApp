package com.example.weatherapp.features.signup

import android.widget.Toast
import androidx.activity.viewModels
import com.example.weatherapp.R
import com.example.weatherapp.core.base.view.BaseActivity
import com.example.weatherapp.databinding.ActivitySignupBinding

class SignupActivity : BaseActivity<ActivitySignupBinding, SignupViewModel>(
    ActivitySignupBinding::inflate
) {

    override val viewModel: SignupViewModel by viewModels()

    override fun onInitView() {

    }

    override fun onInitListener() {
        binding.btnSignup.setOnClickListener {
            val email = binding.etMail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val repass = binding.etRepass.text.toString().trim()
            val phoneText = binding.etPhone.text.toString().trim()

            // Validate input fields
            if (repass.isEmpty()) {
                binding.etRepass.error = getString(R.string.error_password_not_match)
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.etPassword.error = getString(R.string.error_password_required)
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                binding.etMail.error = getString(R.string.error_email_required)
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etMail.error = getString(R.string.error_invalid_email)
                return@setOnClickListener
            }

            if (phoneText.isEmpty()) {
                binding.etPhone.error = getString(R.string.error_phone_required)
                return@setOnClickListener
            }

            val phone = phoneText.toLongOrNull()
            if (phone == null || phone <= 0) {
                binding.etPhone.error = getString(R.string.error_invalid_phone)
                return@setOnClickListener
            }

            // Pass data to ViewModel for processing
            viewModel.signup(repass, password, email, phone)
        }
    }

    override fun onObserveData() {
        super.onObserveData()

        viewModel.signupState.observe(this) { success ->
            if (success) {
                Toast.makeText(this, getString(R.string.toast_register_successful), Toast.LENGTH_SHORT).show()
                finish()

            }
        }
    }
}
