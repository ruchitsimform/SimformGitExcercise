package simform.gitexcercise.android.module.authentication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import simform.gitexcercise.android.MainActivity
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureFields()
        binding.btnSignup.setOnClickListener {
            doSignup()
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
        binding.etConfirmPassword.addTextChangedListener {
            binding.tlConfirmPassword.isErrorEnabled = false
            binding.tlConfirmPassword.error = null
        }
    }

    private fun doSignup() {
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
        if (binding.etConfirmPassword.text.isNullOrEmpty()) {
            binding.tlConfirmPassword.isErrorEnabled = true
            binding.tlConfirmPassword.error = getString(R.string.empty_password_error)
            return
        }
        if (binding.etConfirmPassword.text.toString() != binding.etPassword.text.toString()) {
            Snackbar.make(binding.root,
                getString(R.string.password_not_matching_error), Snackbar.LENGTH_SHORT)
                .setBackgroundTint(Color.RED)
                .show()
            return
        }
        startActivity(Intent(this, MainActivity::class.java))
    }
}