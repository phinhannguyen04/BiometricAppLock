package com.example.biometricapplock.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

private val ObsidianColorScheme = darkColorScheme(
    primary = Primary,
    secondary = Secondary,
    surface = SurfaceBase,
    onSurface = OnSurface,
    onSurfaceVariant = OnSurfaceVariant,
    surfaceContainer = SurfaceContainer,
    surfaceContainerHigh = SurfaceContainerHigh,
    surfaceContainerHighest = SurfaceContainerHighest,
    outlineVariant = OutlineVariant,
    error = ErrorDim
)

@Composable
fun BiometricAppLockTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = ObsidianColorScheme,
        typography = ObsidianTypography,
        shapes = Shapes(
            small = RoundedCornerShape(4.dp),
            medium = RoundedCornerShape(12.dp), // 0.75rem for buttons
            large = RoundedCornerShape(24.dp), // 1.5rem for Biometrics
            extraLarge = RoundedCornerShape(9999.dp) // Full roundness
        ),
        content = content
    )
}

