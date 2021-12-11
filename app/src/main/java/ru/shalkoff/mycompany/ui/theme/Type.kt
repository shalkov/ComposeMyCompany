package ru.shalkoff.mycompany.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.shalkoff.mycompany.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

@OptIn(ExperimentalTextApi::class)
@Composable
fun fontFamily() = FontFamily(
    Font(R.font.sf_pro_text_heavy, FontWeight.Normal),
    Font(R.font.sf_pro_text_heavy, FontWeight.ExtraLight),
)

@Composable
fun typography() = Typography(

    h1 = TextStyle(
        fontFamily = fontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h2 = TextStyle(
        fontFamily = fontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    ),
    h3 = TextStyle(
        fontFamily = fontFamily(),
        fontWeight = FontWeight.ExtraLight,
        fontSize = 14.sp
    )
)