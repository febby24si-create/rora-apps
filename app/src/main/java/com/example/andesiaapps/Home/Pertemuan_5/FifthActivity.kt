package com.example.andesiaapps.Home.Pertemuan_5

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.andesiaapps.R
import com.example.andesiaapps.databinding.ActivityFifthBinding
import com.example.andesiaapps.utils.PermissionHelper
import com.google.android.material.snackbar.Snackbar

class FifthActivity : AppCompatActivity() {

    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Toast.makeText(this, "Notifikasi diizinkan", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Notifikasi ditolak", Toast.LENGTH_SHORT).show()
            }
        }
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

        if (PermissionHelper.isNotificationPermissionRequired()) {
            val permission = Manifest.permission.POST_NOTIFICATIONS
            if (!PermissionHelper.hasPermission(this, permission)) {
                PermissionHelper.requestPermission(
                    notificationPermissionLauncher,
                    permission
                )
            }
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