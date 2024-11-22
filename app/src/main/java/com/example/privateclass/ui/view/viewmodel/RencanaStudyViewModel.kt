package com.example.privateclass.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.privateclass.model.RencanaStudi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RencanaStudyViewModel : ViewModel() {
    private val _krsState = MutableStateFlow(RencanaStudi())
    val krsStateUi: StateFlow<RencanaStudi> = _krsState.asStateFlow()
    fun setMataKuliah(mkPilihan: String) {
        _krsState.update {  stateMK -> stateMK.copy(MataKuliah = mkPilihan) }
    }
    fun setKelas(kelasPilihan: String) {
        _krsState.update {  stateMK -> stateMK.copy(Kelas = kelasPilihan) }
    }
    fun saveDataKRS(ls: List<String>){
        _krsState.update { status -> status.copy(
            MataKuliah = ls[0],
            Kelas = ls[1]
        )
        }
    }
}