package com.example.biometricapplock.ui.features.init

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OnboardingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground())
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "SECURE VAULT",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Icon(Icons.Filled.Settings, contentDescription = null, tint = Color.White)
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Circle Scan UI
            AnimatedScanCircle()

            Spacer(modifier = Modifier.height(20.dp))

            // Title
            Text(
                "Secure Your Apps\nwith Face Unlock",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                "Elevate your privacy with next-gen app security. Quick and seamless protection.",
                color = Color.Gray,
                textAlign = TextAlign.Center,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Features Row
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                FeatureItem("Instant Access", "0.2s unlock")
                FeatureItem("Encrypted", "AES-256")
            }

            Spacer(modifier = Modifier.weight(1f))

            // Button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(Color(0xFF7B6CFF), Color(0xFF9F8CFF))
                        ),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clickable { /* handle click */ },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "GET STARTED",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                "RESTORE PREVIOUS BACKUP",
                color = Color(0xFF7B6CFF),
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun FeatureItem(title: String, subtitle: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            Icons.Filled.Lock,
            contentDescription = null,
            tint = Color(0xFF7B6CFF)
        )
        Text(title, color = Color.White, fontSize = 12.sp)
        Text(subtitle, color = Color.Gray, fontSize = 10.sp)
    }
}

@Composable
fun gradientBackground(): Brush {
    return Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0B0C10),
            Color(0xFF14162E),
            Color(0xFF1F1B3A)
        )
    )
}

@Composable
fun AnimatedScanCircle() {
    val infinite = rememberInfiniteTransition()

    val scale by infinite.animateFloat(
        initialValue = 0.8f,
        targetValue = 1.3f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val alpha by infinite.animateFloat(
        initialValue = 0.3f,
        targetValue = 0.8f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(220.dp)
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            drawCircle(
                color = Color(0xFF7B6CFF).copy(alpha = alpha),
                radius = (size.minDimension / 2) * scale,
                style = Stroke(width = 3.dp.toPx())
            )
        }

        Icon(
            Icons.Default.Face,
            contentDescription = null,
            tint = Color(0xFFB8B8FF),
            modifier = Modifier.size(80.dp)
        )
    }
}