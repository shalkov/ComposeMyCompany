package ru.shalkoff.mycompany.presentation.screens.splash

import androidx.compose.ui.graphics.Color
import ru.shalkoff.mycompany.R

/**
 * Модель описывает состояние Splash экрана
 */
data class SplashState(
    val centerIcon: Int = R.drawable.splash_center_image,
    val bottomIcon: Int = R.drawable.splash_bottom_image,
    val statusBarColor: Color = Color.White
)