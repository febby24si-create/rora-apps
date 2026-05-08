package com.example.andesiaapps

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.andesiaapps.Home.Pertemuan_5.FifthActivity
import com.example.andesiaapps.databinding.ActivityMainBinding
import com.example.andesiaapps.Home.Pertemuan_7.SeventhActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tombol ke FifthActivity
        binding.btnToFifth.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            startActivity(intent)
        }
        // Tombol ke SeventhActivity
        binding.btnToSeventh.setOnClickListener {
            val intent = Intent(this, SeventhActivity::class.java)
            startActivity(intent)
        }
        // Tombol Kirim untuk editTextPhone
        binding.button.setOnClickListener {
            val nomor = binding.editTextPhone.text.toString()
            android.widget.Toast.makeText(this, "Nomor: $nomor", android.widget.Toast.LENGTH_SHORT).show()
        }
    }
}