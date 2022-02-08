package com.brand.projectd.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val White =     Color(0xFFFFFFFF)
val Black =     Color(0xFF000000)

val DarkGray =      Color(0xFF474747)
val MediumGray =    Color(0xFF666666)
val LightGray =     Color(0xFF858585)

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Colors.TrackItemTextColor: Color
    @Composable
    get() = if (isLight) DarkGray else White

val Colors.TrackItemTextSubtitleColor: Color
    @Composable
    get() = if (isLight) LightGray else DarkGray

val Colors.TrackItemPriceColor: Color
    @Composable
    get() = if (isLight) Purple700 else Purple200

val Colors.TrackItemBackgroundColor: Color
    @Composable
    get() = if (isLight) LightGray else DarkGray


val Colors.TopAppBarContentColor: Color
    @Composable
    get() = if (isLight) White else LightGray

val Colors.TopAppBarBackgroundColor: Color
    @Composable
    get() = if (isLight) Purple500 else DarkGray