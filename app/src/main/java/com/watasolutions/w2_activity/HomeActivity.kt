package com.watasolutions.w2_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.watasolutions.w2_activity.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var username : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        val bundle = intent.extras
        bundle?.let {
            val student : Student? = it.getParcelable(Constants.KEY_USER)
            student?.let {
                username = it.username
                binding.tvInfo.text = "${username}"
                binding.editTextUsername.setText(username)
            }
        }
        binding.buttonUpdate.setOnClickListener {
            username = binding.editTextUsername.text.toString().trim()
            binding.tvInfo.text = "${username}"
        }
    }
}