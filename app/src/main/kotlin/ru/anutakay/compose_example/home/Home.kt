package ru.anutakay.compose_example.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import ru.anutakay.compose_example.Screen
import ru.anutakay.compose_example.activities.Activities
import ru.anutakay.compose_example.add_activity.AddActivity

@Composable
internal fun Home() {
    val navController: NavHostController = rememberNavController()
    Scaffold(
        floatingActionButton = { Fab(navController) },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Box(
            Modifier
                .fillMaxWidth()
        ) {
            NavHost(
                navController = navController,
                startDestination = Screen.Activities.route
            ) {
                composable(Screen.Activities.route) {
                    Activities(navController)
                }
                composable(Screen.AddActivity.route) {
                    AddActivity(navController)
                }
            }
        }
    }
}

@Composable
internal fun Fab(navController: NavHostController) {

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        navController.navigate(Screen.AddActivity.route)
        /*coroutineScope.launch {

        }*/
    }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add"
        )
    }
}
