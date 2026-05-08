package com.example.andesiaapps

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.andesiaapps.MainActivity
import com.example.andesiaapps.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            delay(2000) // tampilkan splash 2 detik
            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)

            val intent = if (isLogin) {
                Intent(this@SplashScreenActivity, BaseActivity::class.java)
            } else {
                Intent(this@SplashScreenActivity, AuthActivity::class.java)
            }
            startActivity(intent)
            finish()
        }
    }
}