package com.example.pertemuan9.viewmodel.ex.provider

object PenyediaViewModel {
    iniatializer{
        HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
    }

    iniatializer{
        EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
    }
}

