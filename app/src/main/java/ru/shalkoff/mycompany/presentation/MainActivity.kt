package ru.shalkoff.mycompany.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.shalkoff.mycompany.presentation.screens.ScreenRoute
import ru.shalkoff.mycompany.presentation.screens.main.MainScreen
import ru.shalkoff.mycompany.presentation.screens.splash.SplashScreen
import ru.shalkoff.mycompany.ui.theme.MyCompanyTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyCompanyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoute.SplashScreenRoute.route
                    ) {
                        composable(
                            route = ScreenRoute.SplashScreenRoute.route
                        ) {
                            SplashScreen(navController)
                        }
                        composable(
                            route = ScreenRoute.MainScreenRoute.route
                        ) {
                            MainScreen(navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyCompanyTheme {
        Greeting("Android")
    }
}