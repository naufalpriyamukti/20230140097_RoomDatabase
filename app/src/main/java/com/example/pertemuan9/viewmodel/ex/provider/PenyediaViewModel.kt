package com.example.pertemuan9.viewmodel.ex.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuan9.repositori.AplikasiSiswa
import com.example.pertemuan9.viewmodel.ex.HomeViewModel
import com.example.pertemuan9.viewmodel.ex.EntryViewModel

object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
        }
        //edit: Tambah initializer untuk data viewmodel
        initializer {
            DetailViewModel(this.createSavedStateHandle(),aplikasiSiswa().container.repositoriSiswa)
        }

    }
}

/**
 * Fungsi ekstensi query untuk objek Application dan mengembalikan sebuah instance dari
 * AplikasiSiswa
 */

fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)


