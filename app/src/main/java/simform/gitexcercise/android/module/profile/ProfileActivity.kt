package simform.gitexcercise.android.module.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}