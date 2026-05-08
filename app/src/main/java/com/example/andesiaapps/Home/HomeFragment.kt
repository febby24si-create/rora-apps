package com.example.andesiaapps.Home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.andesiaapps.Home.Pertemuan_5.FifthActivity
import com.example.andesiaapps.Home.Pertemuan_7.SeventhActivity
import com.example.andesiaapps.R
import com.example.andesiaapps.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }
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
    }
}