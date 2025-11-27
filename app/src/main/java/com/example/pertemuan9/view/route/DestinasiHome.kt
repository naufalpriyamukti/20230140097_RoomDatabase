package com.example.pertemuan9.view.route

import com.example.pertemuan9.R
import com.example.pertemuan9.view.route.DestinasiNavigasi

// PERBAIKAN: Tambahkan pewarisan dari interface DestinasiNavigasi
object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = R.string.app_name
}
