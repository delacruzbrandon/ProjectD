package com.brand.projectd.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Colors.TrackItemTextColor: Color
    @Composable
    get() = if (isLight) Color.DarkGray else Color.White


val Colors.TrackItemPriceColor: Color
    @Composable
    get() = if (isLight) Purple700 else Purple200

val Colors.TrackItemBackgroundColor: Color
    @Composable
    get() = if (isLight) Color.LightGray else Color.DarkGray