package com.example.andesiaapps


import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.andesiaapps.Home.HomeFragment
import com.example.andesiaapps.Message.MessageFragment
import com.example.andesiaapps.More.MoreFragment
import com.example.andesiaapps.Note.NoteFragment
import com.example.andesiaapps.databinding.ActivityBaseBinding
import com.example.andesiaapps.databinding.ActivitySeventhBinding

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }
        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    Toast.makeText(this, "Home Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.message -> {
                    replaceFragment(MessageFragment())
                    Toast.makeText(this, "Message Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    replaceFragment(MoreFragment())
                    Toast.makeText(this, "More Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.note -> {
                    replaceFragment(NoteFragment())
                    true
                }

                else -> false // return false jika item tidak ada yang di klik
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            //.addToBackStack(null) -> ini kita nonaktifkan agar saat back langsung keluar aplikasi
            .commit()
    }
}