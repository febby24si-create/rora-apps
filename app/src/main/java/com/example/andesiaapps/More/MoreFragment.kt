package com.example.andesiaapps.More

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter // WAJIB DI-IMPORT
import android.widget.Toast
import com.example.andesiaapps.R
import com.example.andesiaapps.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    // 1. DATA BARU: Sekarang menggunakan List dari Map agar bisa menampung Judul & Deskripsi
    private val dataListWithDesc = listOf(
        mapOf("title" to "Kotlin", "desc" to "Bahasa untuk Android modern"),
        mapOf("title" to "Java", "desc" to "Bahasa OOP yang populer"),
        mapOf("title" to "Python", "desc" to "Bahasa yang mudah dipahami"),
        mapOf("title" to "C++", "desc" to "Bahasa tingkat tinggi untuk performa cepat"),
        mapOf("title" to "JavaScript", "desc" to "Bahasa utama untuk pengembangan web"),
        mapOf("title" to "Dart", "desc" to "Bahasa yang digunakan oleh Flutter framework"),
        mapOf("title" to "Swift", "desc" to "Bahasa resmi untuk pengembangan iOS"),
        mapOf("title" to "Go", "desc" to "Bahasa buatan Google yang sangat efisien"),
        mapOf("title" to "Ruby", "desc" to "Bahasa yang fokus pada kesederhanaan"),
        mapOf("title" to "PHP", "desc" to "Bahasa server-side untuk web dinamis")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /** Toolbar */
        binding.toolbar.title = "More"

        // 2. ADAPTER BARU: Menggunakan SimpleAdapter untuk layout 2 baris (simple_list_item_2)
// UBAH BAGIAN INI SAJA DI onViewCreated:
        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            R.layout.item_list_premium, // <-- Menggunakan layout kartu buatan kita sendiri
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        // Hubungkan listViewItems dengan adapter (masih sama dengan sebelumnya)
        binding.listViewItems.adapter = adapter

        // 3. LOGIKA KLIK BARU: Menampilkan pesan Toast kombinasi Judul dan Deskripsi
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]
            Toast.makeText(requireContext(), "Kamu memilih: $title ($desc)", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}