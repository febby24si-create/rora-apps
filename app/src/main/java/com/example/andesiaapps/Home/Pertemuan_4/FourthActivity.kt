package com.example.andesiaapps.Home.Pertemuan_4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.andesiaapps.MainActivity
import com.example.andesiaapps.R
import com.example.andesiaapps.databinding.ActivityFourthBinding
import com.example.andesiaapps.databinding.ActivityMainBinding
import com.example.andesiaapps.databinding.ActivityThirdBinding

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val name = intent.getStringExtra("nama")
        val age = intent.getIntExtra("asal",0)
        val from = intent.getStringExtra("usia")
        Log.e("Data Intent","Nama: $name , Usia: $age, Asal: $from")

        binding.btnBack.setOnClickListener {
            finish()
        }
        Log.e("onCreate", "FourthActivity dibuat pertama kali")
    }
    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: FourthActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "onStart: FourthActivity dihapus dari stack")
    }
}