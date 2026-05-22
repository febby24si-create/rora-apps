package com.example.andesiaapps.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.andesiaapps.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageAdapter(
    context: Context,
    private val Messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, Messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // 1️⃣ Membaca layout item_message.xml menggunakan View Binding
        val binding = ItemMessageBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        val view = binding.root

        // 2️⃣ Mengambil data berdasarkan posisi baris
        val data = Messages[position]

        // 3️⃣ Load gambar profile dari URL internet + Potong Otomatis Menjadi Bulat (.circleCrop())
        Glide.with(context)
            .load(data.avatarUrl)
            .circleCrop() // 👈 Ini kunci agar foto dari internet berbentuk bulat sempurna
            .into(binding.avatarImg)

        // 4️⃣ Set teks nama pengirim dan pratinjau pesan
        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText

        // 5️⃣ Efek ketika kartu pesan di-klik (Menampilkan Snackbar)
        view.setOnClickListener {
            Snackbar.make(
                parent,
                "Pesan dari ${data.senderName}: ${data.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        return view
    }
}