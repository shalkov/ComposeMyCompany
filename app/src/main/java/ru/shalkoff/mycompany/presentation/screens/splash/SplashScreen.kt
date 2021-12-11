package ru.shalkoff.mycompany.presentation.screens.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import ru.shalkoff.mycompany.presentation.screens.ScreenRoute

const val AnimateDurationTimeMillis = 600

/**
 * Splash экран
 */
@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    var startAnimate by remember { mutableStateOf(false) }
    val sizeCenterAnimation: Dp by animateCenterImage(startAnimate)
    val sizeBottomAnimation: Dp by animateBottomImage(startAnimate)

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painterResource(state.centerIcon),
            contentDescription = "center_image",
            modifier = Modifier
                .size(sizeCenterAnimation)
                .align(Alignment.Center)
        )
        Image(
            painterResource(state.bottomIcon),
            contentDescription = "bottom_image",
            modifier = Modifier
                .size(sizeBottomAnimation)
                .padding(bottom = 24.dp)
                .width(56.dp)
                .height(48.dp)
                .align(Alignment.BottomCenter)
        )
    }
    LaunchedEffect(true) {
        delay(111L)
        startAnimate = true
        delay(AnimateDurationTimeMillis + 600L)
        navController.navigate(ScreenRoute.MainScreenRoute.route)
        {
            popUpTo(ScreenRoute.SplashScreenRoute.route) {
                inclusive = true
            }
        }
    }
}

@Composable
private fun animateCenterImage(startAnimate: Boolean): State<Dp> {
    return animateDpAsState(
        targetValue = if (startAnimate) 500.dp else 0.dp,
        animationSpec = tween(
            durationMillis = AnimateDurationTimeMillis, // duration
            delayMillis = 0, // delay before start animation
            easing = FastOutSlowInEasing
        )
    )
}

@Composable
private fun animateBottomImage(startAnimate: Boolean): State<Dp> {
    return animateDpAsState(
        targetValue = if (startAnimate) 62.dp else 0.dp,
        animationSpec = tween(
            durationMillis = AnimateDurationTimeMillis, // duration
            delayMillis = 0, // delay before start animation
            easing = FastOutSlowInEasing
        )
    )
}