package com.hk_tech.collagebus

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hk_tech.collagebus.databinding.ActivitySupportBinding

class Support : AppCompatActivity() {
    lateinit var binding: ActivitySupportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySupportBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.contactUs.setOnClickListener {
            call(view)
        }

        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun call(view: View) {
        val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:" + "6261001068")
        startActivity(dialIntent)
    }
}