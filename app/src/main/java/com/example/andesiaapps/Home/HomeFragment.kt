package com.example.andesiaapps.Home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andesiaapps.Home.Pertemuan_10.TenthActivity
import com.example.andesiaapps.Home.Pertemuan_5.FifthActivity
import com.example.andesiaapps.Home.Pertemuan_7.SeventhActivity
import com.example.andesiaapps.Home.Pertemuan_9.NinthActivity
import com.example.andesiaapps.Home.photo.PhotoAdapter
import com.example.andesiaapps.data.api.CatFactApiClient
import com.example.andesiaapps.data.api.PhotoApiClient
import com.example.andesiaapps.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

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

        binding.toolbar.title = "Home"
        loadCatFact()
        binding.btnRefresh.setOnClickListener {
            loadCatFact()
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

        // Tombol ke NinthActivity
        binding.btnToNinth.setOnClickListener {
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }
        // Tombol ke TenthActivity
        binding.btnToTenth.setOnClickListener {
            val intent = Intent(requireContext(), TenthActivity::class.java)
            startActivity(intent)
        }
        loadPhoto()
    }

    private fun loadCatFact() {
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()

                _binding?.tvCatFact?.text = "\"${response.fact}\""

            } catch (e: Exception) {
                _binding?.tvCatFact?.text = "Gagal mengambil fakta kucing."
            }
        }
    }

    private fun loadPhoto() {
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.PhotoApiClient.apiService.getPhotos()

                _binding?.rvGallery?.adapter = PhotoAdapter(photos)

                _binding?.rvGallery?.layoutManager =
                    GridLayoutManager(requireContext(), 2)

            } catch (e: Exception) {
                if (isAdded) {
                    Toast.makeText(
                        requireContext(),
                        "Gagal memuat gambar",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}