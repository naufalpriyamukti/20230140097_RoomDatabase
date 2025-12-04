package com.example.pertemuan9.repositori

import androidx.room.Delete
import androidx.room.Query
import com.example.pertemuan9.room.Siswa
import com.example.pertemuan9.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa{

    fun getAllSiswaStream(): Flow<List<Siswa>>

    suspend fun insertSiswa(siswa: Siswa)

    @Query("SELECT * from tblSiswa WHERE id =:id")
    fun getSiswa(id: Int): Flow<Siswa>

    @Delete
    suspend fun delete(siswa: Siswa)

    suspend fun updateSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(
    private val siswaDao: SiswaDao
) : RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)

    override fun getSiswaStream(id: Int): Flow<Siswa?> = siswaDao.getSiswa(id)
    override suspend fun deleteSiswa(siswa: Siswa) = siswaDao.delete(siswa)
}