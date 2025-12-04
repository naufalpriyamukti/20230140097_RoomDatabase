package com.example.pertemuan9.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pertemuan9.repositori.RepositoriSiswa
import com.example.pertemuan9.view.route.DestinasiEditSiswa
import com.example.pertemuan9.viewmodel.ex.DetailSiswa
import com.example.pertemuan9.viewmodel.ex.UIStateSiswa
import com.example.pertemuan9.viewmodel.ex.toSiswa
import com.example.pertemuan9.viewmodel.ex.toUiStateSiswa
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa
) : ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private val itemId: Int = checkNotNull(savedStateHandle[DestinasiEditSiswa.itemIdArg])

    init {
        viewModelScope.launch {
            // Ambil data siswa sekali saja dan perbarui state
            uiStateSiswa = repositoriSiswa.getSiswaStream(itemId)
                .filterNotNull()
                .first()
                .toUiStateSiswa(true)
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    suspend fun updateSiswa() {
        if (validasiInput(uiStateSiswa.detailSiswa)) {
            repositoriSiswa.updateSiswa(uiStateSiswa.detailSiswa.toSiswa())
        }
    }

    private fun validasiInput(detailSiswa: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(detailSiswa) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }
}
