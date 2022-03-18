package com.nutriagora.nutriagora.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = texte,
    primaryVariant = topBar,
    secondary = black
)

private val LightColorPalette = lightColors(
    primary = texte,
    primaryVariant = topBar,
    secondary = black

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun NutriAgoraTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}