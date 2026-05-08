package com.example.andesiaapps.Home.Pertemuan_7

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.andesiaapps.R
import com.example.andesiaapps.databinding.ActivitySeventhBinding

class SeventhActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeventhBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeventhBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        binding = ActivitySeventhBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Rezy Seventh"
            subtitle = "Ini adalah subtitle"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        // Menampilkan fragment pertama secara default
        replaceFragment(SatuFragment())

        // Setup event click untuk mengganti fragment
        binding.button2.setOnClickListener {
            replaceFragment(SatuFragment())
        }

        binding.button3.setOnClickListener {
            replaceFragment(DuaFragment())
        }

        binding.button4.setOnClickListener {
            replaceFragment(TigaFragment())
        }

    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .addToBackStack(null)
            .commit()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
