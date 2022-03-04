package com.hk_tech.collagebus

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.hk_tech.collagebus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        toggle = ActionBarDrawerToggle(this, binding.DrawerLayout, R.string.open, R.string.close)
        binding.DrawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {


                R.id.supportMenu -> {
                    val intent = Intent(this, Support::class.java)
                    startActivity(intent)
                }

                R.id.aboutMenu -> {
                    val intent = Intent(this, About::class.java)
                    startActivity(intent)
                }

                R.id.logoutMenu -> Toast.makeText(applicationContext,
                    "Logout",
                    Toast.LENGTH_SHORT).show()

                R.id.profileMenu -> {
                    val intent = Intent(this, Profile::class.java)
                    startActivity(intent)
                }
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}