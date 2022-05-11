package com.dxn.pizzae.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val NonVegLightColorPalette = darkColors(
    primary = Red3,
    onPrimary = Color.White,
    secondary = Red2,
    onSecondary = Red3,
    primaryVariant = Red1,
    background = Color.White,
    onBackground = Red3
)

private val VegLightColorPalette = lightColors(
    primary = Green3,
    onPrimary = Color.White,
    secondary = Green2,
    onSecondary = Green3,
    primaryVariant = Green1,
    background = Color.White,
    onBackground = Green3
)

@Composable
fun PizzaeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    isVeg: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        if (isVeg) VegLightColorPalette else NonVegLightColorPalette
    } else {
        if (isVeg) VegLightColorPalette else NonVegLightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}