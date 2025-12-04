package com.example.pertemuan9.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pertemuan9.viewmodel.ViewModelProvider
import com.example.pertemuan9.viewmodel.EditViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditSiswaScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    // PERBAIKAN: Memanggil ViewModel menggunakan Factory yang benar.
    viewModel: EditViewModel = viewModel(factory = ViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            SiswaTopAppBar(
                title = "Edit Siswa", // Contoh Judul
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        EntrySiswaBody(
            uiStateSiswa = viewModel.uiStateSiswa,
            onSiswaValueChange = viewModel::updateUiState,
            onSaveClick = {
                // Jalankan coroutine untuk menyimpan data
                coroutineScope.launch {
                    viewModel.updateSiswa()
                    navigateBack()
                }
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}
