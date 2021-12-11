package ru.shalkoff.mycompany.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.shalkoff.mycompany.ui.theme.White_Gray

@Composable
fun MainScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(color = White_Gray)

    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "MainScreen", modifier = Modifier.align(Alignment.Center))
    }
}