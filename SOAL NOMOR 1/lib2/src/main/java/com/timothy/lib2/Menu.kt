package com.timothy.lib2

class Menu(
    private val nama: String,
    private var harga: Int
) {
    fun getNama(): String = nama
    fun getHarga(): Int = harga
    fun setHarga(value: Int) { harga = value }
}
