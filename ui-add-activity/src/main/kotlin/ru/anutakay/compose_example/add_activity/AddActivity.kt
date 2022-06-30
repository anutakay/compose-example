package ru.anutakay.compose_example.add_activity

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AddActivity(navController: NavController) = AddActivity(
    viewModel = androidx.hilt.navigation.compose.hiltViewModel(),
    navController = navController,
)

@Composable
internal fun AddActivity(
    viewModel: AddActivityViewModel,
    navController: NavController,
) {
    Text("AAAAAAAA")
}
