package ru.anutakay.compose_example.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.anutakay.compose_example.Screen
import ru.anutakay.compose_example.activitiesScaffold.ActivitiesScaffold
import ru.anutakay.compose_example.add_activity.AddActivity

@Composable
internal fun Home() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Activities.route
    ) {
        composable(Screen.Activities.route) {
            ActivitiesScaffold(
                navController,
                onFabClick = { navController.navigate(Screen.AddActivity.route) }
            )
        }
        composable(Screen.AddActivity.route) {
            AddActivity(navController)
        }
    }
}
