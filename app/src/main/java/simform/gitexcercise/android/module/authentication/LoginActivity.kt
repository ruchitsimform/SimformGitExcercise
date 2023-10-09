package simform.gitexcercise.android.module.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import simform.gitexcercise.android.MainActivity
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureFields()
        setUpClickListeners()
    }

    private fun setUpClickListeners() {
        binding.btnLogin.setOnClickListener {
            doLogin()
        }

        binding.btnCreateAccount.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

        binding.btnForgotPassword.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }

    private fun configureFields() {
        binding.etUsername.addTextChangedListener {
            binding.tlUsername.isErrorEnabled = false
            binding.tlUsername.error = null
        }
        binding.etPassword.addTextChangedListener {
            binding.tlPassword.isErrorEnabled = false
            binding.tlPassword.error = null
        }
    }

    private fun doLogin() {
        if (binding.etUsername.text.isNullOrEmpty()) {
            binding.tlUsername.isErrorEnabled = true
            binding.tlUsername.error = getString(R.string.empty_username_error)
            return
        }
        if (binding.etPassword.text.isNullOrEmpty()) {
            binding.tlPassword.isErrorEnabled = true
            binding.tlPassword.error = getString(R.string.empty_password_error)
            return
        }
        startActivity(Intent(this, MainActivity::class.java))
    }
}