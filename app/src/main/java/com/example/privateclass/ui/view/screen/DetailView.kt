package com.example.privateclass.ui.view.screen

import androidx.compose.foundation.content.MediaType
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.privateclass.model.Mahasiswa
import com.example.privateclass.model.RencanaStudi

@Composable
fun DatailView(
    mahasiswa: Mahasiswa,
    rencanaStudi: RencanaStudi,
    onBackButtonClicked: () -> Unit,
    onResetButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Detail Mahasiswa",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center)
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            DetailRow(label = "NIM", value = mahasiswa.nim,
                modifier = Modifier.weight(1f))                         // Memberikan proporsi ke kolom pertama
            DetailRow(label = "", value = mahasiswa.email,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End )                             //agar emailnya berada di kanan
        }
            DetailRow(label = "Nama", value = mahasiswa.nama)
        Spacer(modifier = Modifier.padding(8.dp))

