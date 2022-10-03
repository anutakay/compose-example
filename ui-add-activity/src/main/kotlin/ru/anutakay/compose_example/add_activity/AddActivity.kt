package ru.anutakay.compose_example.add_activity

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.anutakay.compose_example.model.entities.Activity
import java.time.LocalDateTime

@ExperimentalMaterial3Api
@Composable
fun AddActivity(navController: NavController) = AddActivity(
    viewModel = androidx.hilt.navigation.compose.hiltViewModel(),
    navController = navController,
)

@ExperimentalMaterial3Api
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
            SaveActivityButton(viewModel, activityTitleState, navController)
        }
    }
}

@ExperimentalMaterial3Api
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
    viewModel: AddActivityViewModel,
    title: State<String>,
    navController: NavController
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        onClick = {
            viewModel.addActivity(Activity(title.value, LocalDateTime.now()))
            navController.popBackStack()
        }
    ) {
        Text(text = "SAVE")
    }
}
