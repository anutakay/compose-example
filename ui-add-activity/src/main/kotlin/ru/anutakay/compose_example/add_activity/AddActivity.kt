package ru.anutakay.compose_example.add_activity

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

@Composable
fun AddActivity(navController: NavController) = AddActivity(
    viewModel = androidx.hilt.navigation.compose.hiltViewModel(),
    navController = navController,
)

@Composable
internal fun AddActivity(
    viewModel: ViewModel,
    navController: NavController,
) {

}
