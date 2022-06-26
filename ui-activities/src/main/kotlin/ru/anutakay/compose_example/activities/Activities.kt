package ru.anutakay.compose_example.activities

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun Activities(navController: NavController) = Activities(
    viewModel = hiltViewModel(),
    navController = navController,
)

@Composable
internal fun Activities(
    viewModel: ActivitiesViewModel,
    navController: NavController,
) {

}
