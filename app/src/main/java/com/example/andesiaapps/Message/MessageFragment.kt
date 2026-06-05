package com.example.andesiaapps.Message

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.andesiaapps.Message.tutorial.TutorialMessageActivity
import com.example.andesiaapps.R
import com.example.andesiaapps.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    // 1️⃣ Inisialisasi View Binding untuk Fragment
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    // 2️⃣ Data messageList
    private val messageList = listOf(
        MessageModel(
            "Alya",
            "Halo! Apa kabar?",
            "https://api.dicebear.com/7.x/avataaars/png?seed=Alya"
        ),
        MessageModel(
            "Budi",
            "Sudah makan?",
            "https://api.dicebear.com/7.x/avataaars/png?seed=Budi"
        ),
        MessageModel(
            "Citra",
            "Jangan lupa tugasnya ya!",
            "https://api.dicebear.com/7.x/avataaars/png?seed=Citra"
        ),
        MessageModel(
            "Dika",
            "Besok kita rapat jam 9",
            "https://api.dicebear.com/7.x/avataaars/png?seed=Dika"
        ),
        MessageModel(
            "Eka",
            "Nice job kemarin!",
            "https://api.dicebear.com/7.x/avataaars/png?seed=Eka"
        ),
        MessageModel(
            "Fajar",
            "Lagi ngapain?",
            "https://api.dicebear.com/7.x/avataaars/png?seed=Fajar"
        ),
        MessageModel(
            "Gita",
            "Boleh minta tolong?",
            "https://api.dicebear.com/7.x/avataaars/png?seed=Gita"
        ),
        MessageModel(
            "Hana",
            "Lihat email ya",
            "https://api.dicebear.com/7.x/avataaars/png?seed=Hana"
        ),
        MessageModel("Irfan", "Oke noted", "https://api.dicebear.com/7.x/avataaars/png?seed=Irfan"),
        MessageModel(
            "Joko",
            "Sampai jumpa besok",
            "https://api.dicebear.com/7.x/avataaars/png?seed=Joko"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 3️⃣ Inflate menggunakan View Binding
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true) // ✅ Dipindahkan ke sini
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Toolbar
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Message"
        }

        // 4️⃣ Penerapan MessageAdapter
        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    // 5️⃣ Bersihkan binding saat fragment dihancurkan (dipindahkan ke luar)
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}