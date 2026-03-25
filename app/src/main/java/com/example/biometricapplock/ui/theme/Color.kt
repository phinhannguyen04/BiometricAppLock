package com.example.biometricapplock.ui.theme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Core Accents
val Primary = Color(0xFFD0BCFF)
val Secondary = Color(0xFF8596FF)
val Tertiary = Color(0xFFD0BCFF) // Progress indicator tertiary
val ErrorDim = Color(0xFFD73357)

// Surface Hierarchy (The Obsidian Foundation)
val SurfaceBase = Color(0xFF0E0E11)
val SurfaceContainerLowest = Color(0xFF000000)
val SurfaceContainerLow = Color(0xFF16151A) // Derived for layering
val SurfaceContainer = Color(0xFF1A191E)
val SurfaceContainerHigh = Color(0xFF201F24)
val SurfaceContainerHighest = Color(0xFF26252B)

// Content (On-Surfaces)
val OnSurface = Color(0xFFF1ECF2)
val OnSurfaceVariant = Color(0xFFADAAF)
val OutlineVariant = Color(0xFF49474C).copy(alpha = 0.15f) // The "Ghost Border"

// Signatures
val VaultGradient = Brush.linearGradient(
    colors = listOf(Primary, Secondary),
    start = androidx.compose.ui.geometry.Offset(0f, 0f),
    end = androidx.compose.ui.geometry.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
)