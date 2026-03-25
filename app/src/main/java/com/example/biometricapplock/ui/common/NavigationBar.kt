package com.example.biometricapplock.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.biometricapplock.ui.navigation.currentRoute
import com.example.biometricapplock.ui.theme.Primary
import com.example.biometricapplock.ui.theme.SurfaceBase


sealed class Screen (val route: String, val label: String, val icon: ImageVector) {
    object Home: Screen("home", "Home", Icons.Filled.Home)
    object App: Screen("app", "App", Icons.Filled.Menu)
    object History: Screen("history", "History", Icons.Filled.List)
    object Settings: Screen("settings", "Settings", Icons.Filled.Settings)
}
@Composable
fun BottomNavigationBar(navController: NavController) {
    val listItem = listOf(
        Screen.Home,
        Screen.App,
        Screen.History,
        Screen.Settings
    )

    NavigationBar {
        val currentRoute = currentRoute(navController)

        listItem.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = when(screen) {
                            Screen.Home -> Screen.Home.icon
                            Screen.App -> Screen.App.icon
                            Screen.History -> Screen.History.icon
                            Screen.Settings -> Screen.Settings.icon
                        },
                        contentDescription = screen.label
                    )
                },
                label = {Text(screen.label, style = MaterialTheme.typography.labelSmall)},
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(Screen.Home.route)
                        launchSingleTop = true
                    }
                },
                modifier = Modifier
                    .padding(16.dp)
                    .size(40.dp),
            )
        }
    }
}
