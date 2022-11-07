package ru.anutakay.compose_example.activitiesScaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.anutakay.compose_example.activities.Activities

@ExperimentalMaterial3Api
@Composable
fun ActivitiesScaffold(
    navController: NavHostController,
    onFabClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.padding(0.dp),
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = onFabClick) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) { Activities(navController) }
    }
}
