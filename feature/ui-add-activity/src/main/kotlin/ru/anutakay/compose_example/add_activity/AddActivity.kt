package ru.anutakay.compose_example.add_activity

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.anutakay.compose_example.model.entities.Activity
import java.time.LocalDateTime
import ru.anutakay.compose_example.common_ui.SaveButtonBox

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
    val titleState = rememberSaveable { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = titleState.value,
                onValueChange = { titleState.value = it })
        }
    }

    SaveButtonBox(
        onButtonClick = {
            viewModel.addActivity(Activity(titleState.value, LocalDateTime.now()))
            navController.popBackStack()
        }
    )
}
