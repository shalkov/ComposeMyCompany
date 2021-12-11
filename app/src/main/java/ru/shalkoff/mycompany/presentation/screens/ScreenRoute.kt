package ru.shalkoff.mycompany.presentation.screens

/**
 * Маршруты экранов
 */
sealed class ScreenRoute(val route: String) {
    object SplashScreenRoute: ScreenRoute("splash_screen")
    object MainScreenRoute: ScreenRoute("main_screen")
}