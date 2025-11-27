package com.example.pertemuan9.view.route

interface DestinasiNavigasi {
    /**
     * nama unik untuk menentukan jalur untuk composable
     */
    val route: String

    /**
     * String resource id yang berisi judul yang akan ditampilkan dilayar halaman
     *
     */
    val titleRes: Int
}