package com.example.pertemuan9.viewmodel

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuan9.repositori.AplikasiSiswa
import com.example.pertemuan9.viewmodel.EditViewModel
import com.example.pertemuan9.viewmodel.ex.DetailViewModel
import com.example.pertemuan9.viewmodel.ex.EntryViewModel
import com.example.pertemuan9.viewmodel.ex.HomeViewModel

object ViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer untuk EntryViewModel
        initializer {
            EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
        }

        // Initializer untuk HomeViewModel
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
        }

        // Initializer untuk DetailViewModel
        initializer {
            DetailViewModel(
                this.createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa
            )
        }

        // Initializer untuk EditViewModel
        initializer {
            EditViewModel(
                this.createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa
            )
        }
    }
}

/**
 * Fungsi ekstensi untuk mendapatkan instance aplikasi dengan aman dari CreationExtras.
 */
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)
