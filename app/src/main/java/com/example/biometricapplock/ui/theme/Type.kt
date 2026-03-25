package com.example.biometricapplock.ui.theme


import com.example.biometricapplock.R
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.sp



val Manrope = FontFamily(
    Font(resId = R.font.manrope_regular, weight = FontWeight.Normal),
    Font(resId = R.font.manrope_medium, weight = FontWeight.Medium),
    Font(resId = R.font.manrope_bold, weight = FontWeight.Bold)
)
val ObsidianTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Bold,
        fontSize = 57.sp,
        letterSpacing = (-1.14).sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        color = OnSurface
    ),
    bodyMedium = TextStyle(
        fontFamily = Manrope,
        fontSize = 16.sp,
        color = OnSurfaceVariant
    ),
    labelSmall = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        letterSpacing = 0.55.sp,
        textMotion = TextMotion.Animated
    )
)