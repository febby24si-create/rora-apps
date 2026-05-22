package com.example.andesiaapps.Home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.andesiaapps.Home.Pertemuan_5.FifthActivity
import com.example.andesiaapps.Home.Pertemuan_7.SeventhActivity
import com.example.andesiaapps.Home.Pertemuan_9.NinthActivity
import com.example.andesiaapps.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // PERBAIKAN 1: Atur judul langsung ke Toolbar lokal Fragment,
        // tanpa perlu setSupportActionBar ke Activity induk.
        binding.toolbar.title = "Home"

        // Tombol ke FifthActivity
        binding.btnToFifth.setOnClickListener {
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        // Tombol ke SeventhActivity
        binding.btnToSeventh.setOnClickListener {
            val intent = Intent(requireContext(), SeventhActivity::class.java)
            startActivity(intent)
        }

        // Tombol ke NinthActivity
        binding.btnToNinth.setOnClickListener {
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }
    }

    // PERBAIKAN 2: Wajib bersihkan binding di onDestroyView untuk mencegah kebocoran memori
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}