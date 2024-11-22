package com.example.privateclass.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.privateclass.ui.view.screen.DatailView
import com.example.privateclass.ui.view.screen.MahasiswaFormView
import com.example.privateclass.ui.view.screen.RencanaStudyView
import com.example.privateclass.ui.view.screen.SplashView
import com.example.privateclass.ui.view.viewmodel.MahasiswaViewModel
import com.example.privateclass.ui.view.viewmodel.RencanaStudyViewModel

enum class Halaman {
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val mahasiswaUiState = mahasiswaViewModel.statusUI.collectAsState().value
    val rencanaStudiUiState = krsViewModel.krsStateUi.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = modifier.padding()
    ) {
        composable(route = Halaman.Splash.name) {
            SplashView(onMulaiButton = {
                navController.navigate(Halaman.Mahasiswa.name)
            })
        }
        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.Matakuliah.name)
                },
                onBackButtonClicked = { navController.popBackStack() }
            )
        }
        composable(route = Halaman.Matakuliah.name) {
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = { krs -> krsViewModel.saveDataKRS(krs)
                    navController.navigate(Halaman.Tampil.name)
                },
                onBackButtonClicked = { navController.popBackStack() }
            )
        }
        composable(route = Halaman.Tampil.name) {
            DatailView(
                mahasiswa = mahasiswaUiState,
                rencanaStudi = rencanaStudiUiState,
                onBackButtonClicked = { navController.popBackStack() },
                onResetButtonClicked = {
                    navController.navigate(Halaman.Splash.name) {
                        popUpTo(Halaman.Splash.name) { inclusive = true }
                    }
                }
            )
        }
    }
}