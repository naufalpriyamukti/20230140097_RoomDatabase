package com.example.pertemuan9.viewmodel.ex

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pertemuan9.repositori.RepositoriSiswa

class EntryViewModel(private val repositori: RepositoriSiswa): ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set
    /* Fungsi untuk memvalidasi input*/

    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa
        .detailSiswa ): Boolean {
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa =
            UIStateSiswa(detailSiswa = detailSiswa,
                isEntryValid = validasiInput(detailSiswa))

    }
}

data class UIStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)

data class DetailSiswa(
    val id: Int = 0,
    val nama: String,
    val alamat: String
)




