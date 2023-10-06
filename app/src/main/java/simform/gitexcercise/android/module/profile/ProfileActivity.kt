package simform.gitexcercise.android.module.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private val previewRequest = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            val list = it.data
            binding.txtName.text = list?.getStringExtra("name") ?: getString(R.string.test)
            binding.txtSurname.text = list?.getStringExtra("surname") ?: getString(R.string.test)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEditProfile.setOnClickListener {
            previewRequest.launch(Intent(this, EditProfileActivity::class.java))
        }
    }
}