package simform.gitexcercise.android.module.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etEmail.addTextChangedListener {
            binding.tlEmail.isErrorEnabled = false
            binding.tlEmail.error = null
        }

        binding.btnReset.setOnClickListener {
            if (binding.etEmail.text.isNullOrEmpty()) {
                binding.tlEmail.isErrorEnabled = true
                binding.tlEmail.error = getString(R.string.email_can_not_be_empty)
            } else {
                Snackbar.make(binding.root, getString(R.string.reset_email_sent_successfully), Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}