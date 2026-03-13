package com.example.andesiaapps.Pertemuan_2

fun main() {
    println("Hi rekan-rekan...")
    println("Selamat datang di bahasa pemogramanb Kotlin")

    println("===========")

    var angka = 15
    println("Hasil dari 15+10 = ${angka + 10}")

    var  nilaiInt = 10000
    var nilaiDouble = 100.003
    var nilaiFloat = 100.0f

    println("Nilai Integer = $nilaiInt")
    println("Nilai Double = $nilaiDouble")
    println("Nilai Floa = $nilaiFloat")

    println("==========String===========")
    val huruf = 'a'
    println("Ini pggunaa karakter '$huruf'")

    val nilaiString= "Mawar"
    println("Halo $nilaiString!\nApa Kabar?")

    println("=======KOndisi========")

    val nilai = 10
    if (nilai<0)
        println("Bilangan Negatif")
    else
        println("Bilangan Ganjil")

    println("==========Peulangan=========")
    val kampusKu: Array<String> = arrayOf("Kampus", "Politeknik", "Caltex", "Riau")
    for (kampus: String in kampusKu) {
        println(kampus)
    }
}