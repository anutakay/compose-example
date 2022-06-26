package ru.anutakay.compose_example.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.anutakay.compose_example.Screen
import ru.anutakay.compose_example.activities.Activities

@Composable
internal fun Home() {
    Column {
        val navController: NavHostController = rememberNavController()
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            NavHost(
                navController = navController,
                startDestination = Screen.Activities.route
            ) {
                composable(Screen.Activities.route) {
                    Activities(navController)
                }
            }
        }
    }
}
