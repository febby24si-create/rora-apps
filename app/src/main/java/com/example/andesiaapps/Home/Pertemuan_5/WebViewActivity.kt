package com.example.andesiaapps.Home.Pertemuan_5

import android.R
import android.graphics.Bitmap
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.andesiaapps.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding
    private var lastBackPressedTime = 0L // Untuk double tap reload

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Web Merdeka"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // Improvisasi: WebViewClient dengan error handling dan loading indicator
        binding.webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                // Indikator loading sederhana
                Toast.makeText(this@WebViewActivity, "Memuat halaman...", Toast.LENGTH_SHORT).show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Toast.makeText(this@WebViewActivity, "Halaman selesai dimuat", Toast.LENGTH_SHORT).show()
            }

            override fun onReceivedError(
                view: WebView?,
                errorCode: Int,
                description: String?,
                failingUrl: String?
            ) {
                super.onReceivedError(view, errorCode, description, failingUrl)
                // Tampilkan halaman error custom (HTML sederhana)
                val errorHtml = """
                    <html><body style='text-align:center; padding:50px;'>
                    <h2>⚠️ Gagal memuat halaman</h2>
                    <p>Error: $description</p>
                    <p>Periksa koneksi internet Anda</p>
                    </body></html>
                """.trimIndent()
                view?.loadDataWithBaseURL(null, errorHtml, "text/html", "UTF-8", null)
            }
        }

        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://merdeka.com")

        // Hide/show toolbar saat scroll (improvisasi: tambahkan kondisi)
        binding.webView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            when {
                scrollY > oldScrollY + 20 -> binding.appBar.setExpanded(false, true)   // scroll bawah
                scrollY < oldScrollY - 20 -> binding.appBar.setExpanded(true, true)    // scroll atas
            }
        }
    }

    // Improvisasi: Konfirmasi keluar + double tap reload
    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            // Double tap untuk reload
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastBackPressedTime < 2000) {
                // Double tap: reload halaman
                binding.webView.reload()
                Toast.makeText(this, "Muat ulang halaman", Toast.LENGTH_SHORT).show()
                lastBackPressedTime = 0
            } else {
                lastBackPressedTime = currentTime
                // Konfirmasi keluar
                AlertDialog.Builder(this)
                    .setTitle("Keluar")
                    .setMessage("Apakah Anda ingin keluar dari WebView?")
                    .setPositiveButton("Ya") { _, _ -> super.onBackPressed() }
                    .setNegativeButton("Tidak", null)
                    .show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}