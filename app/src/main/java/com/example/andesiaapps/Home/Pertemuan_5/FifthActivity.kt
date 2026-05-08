package com.example.andesiaapps.Home.Pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.andesiaapps.R
import com.example.andesiaapps.databinding.ActivityFifthBinding
import com.google.android.material.snackbar.Snackbar

class FifthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Febby Fahrezy"
            subtitle = "Ini adalah rezy"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        binding.btnWebView.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                // IMPROVISASI: Snackbar dengan aksi tambahan
                Snackbar.make(binding.root, "Fitur pencarian akan segera hadir", Snackbar.LENGTH_LONG)
                    .setAction("Coba") {
                        Snackbar.make(binding.root, "Pencarian dibatalkan", Snackbar.LENGTH_SHORT).show()
                    }
                    .show()
                true
            }
            R.id.action_settings -> {
                // IMPROVISASI: Snackbar notifikasi
                Snackbar.make(binding.root, "Pengaturan belum tersedia", Snackbar.LENGTH_SHORT).show()
                true
            }
            
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}