package ru.anutakay.compose_example.add_activity

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    val activityTitleState = rememberSaveable { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            ActivityTitleTextField(activityTitleState)
            SaveActivityButton(activityTitleState, navController)
        }
    }
}

@Composable
private fun ActivityTitleTextField(
    title: MutableState<String>
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = title.value,
        onValueChange = { title.value = it })
}

@Composable
private fun SaveActivityButton(
    title: State<String>,
    navController: NavController
) {
    var enabled by rememberSaveable { mutableStateOf(true) }

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        enabled = enabled,
        onClick = {
            enabled = false
            println(title.value)
            navController.popBackStack()
        }
    ) {
        Text(text = "SAVE")
    }

}
