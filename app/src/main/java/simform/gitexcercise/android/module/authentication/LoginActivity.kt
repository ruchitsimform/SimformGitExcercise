package simform.gitexcercise.android.module.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import simform.gitexcercise.android.MainActivity
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.ActivityLoginBinding
import simform.gitexcercise.android.module.profile.ProfileActivity
import simform.gitexcercise.android.utility.StrongPasswordPattern

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
        when (isPasswordStrong(binding.etPassword.text.toString())) {
            PasswordError.Number -> {
                binding.tlPassword.isErrorEnabled = true
                binding.tlPassword.error =
                    getString(R.string.password_must_contains_at_least_1_number)
            }

            PasswordError.SmallAlphabet -> {
                binding.tlPassword.isErrorEnabled = true
                binding.tlPassword.error =
                    getString(R.string.password_must_contains_at_least_1_small_alphabet)
            }

            PasswordError.CapitalAlphabet -> {
                binding.tlPassword.isErrorEnabled = true
                binding.tlPassword.error =
                    getString(R.string.password_must_contains_at_least_1_capital_alphabet)
            }

            PasswordError.SpecialCharacter -> {
                binding.tlPassword.isErrorEnabled = true
                binding.tlPassword.error =
                    getString(R.string.password_must_contains_at_least_1_special_character)
            }

            PasswordError.Length -> {
                binding.tlPassword.isErrorEnabled = true
                binding.tlPassword.error = getString(R.string.password_length_must_be_8_to_20)
            }

            PasswordError.None -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    private fun isPasswordStrong(password: String): PasswordError {
        return if (!StrongPasswordPattern.NUMBER.toRegex().containsMatchIn(password)) {
            PasswordError.Number
        } else if (!StrongPasswordPattern.SMALL_ALPHABET.toRegex().containsMatchIn(password)) {
            PasswordError.SmallAlphabet
        } else if (!StrongPasswordPattern.CAPITAL_ALPHABET.toRegex().containsMatchIn(password)) {
            PasswordError.CapitalAlphabet
        } else if (!StrongPasswordPattern.SPECIAL_CHARACTER.toRegex().containsMatchIn(password)) {
            PasswordError.SpecialCharacter
        } else if (!StrongPasswordPattern.LENGTH.toRegex().containsMatchIn(password)) {
            PasswordError.Length
        } else {
            PasswordError.None
        }
    }

    enum class PasswordError {
        Number, SmallAlphabet, CapitalAlphabet, Length, SpecialCharacter, None
    }
}