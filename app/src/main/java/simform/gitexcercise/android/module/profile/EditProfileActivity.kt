package simform.gitexcercise.android.module.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureFields()
        binding.btnSubmit.setOnClickListener {
             editProfile()
        }
    }

    private fun editProfile() {
        if (binding.etName.text.isNullOrEmpty()) {
            binding.tlName.isErrorEnabled = true
            binding.tlName.error = getString(R.string.name_can_not_be_empty)
            return
        }
        if (binding.etSurname.text.isNullOrEmpty()) {
            binding.tlSurname.isErrorEnabled = true
            binding.tlSurname.error = getString(R.string.surname_can_not_be_empty)
            return
        }
        val intent = Intent()
        intent.putExtra("name", binding.etName.text.toString())
        intent.putExtra("surname", binding.etSurname.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }

    private fun configureFields() {
        binding.etName.addTextChangedListener {
            binding.tlName.apply {
                isErrorEnabled = false
                error = null
            }
        }
        binding.etSurname.addTextChangedListener {
            binding.tlSurname.apply {
                isErrorEnabled = false
                error = null
            }
        }
    }
}