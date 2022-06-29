package ru.anutakay.compose_example.activities

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
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
    Column {
        ActivitiesGroupedByDay(viewModel)
    }
}

@Composable
private fun ActivitiesList(
    viewModel: ActivitiesViewModel
) {
    LazyColumn {
        viewModel.activities.forEach {
            item {
                Text(text = "activity: ${it.title}, time: ${it.dateTime}")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ActivitiesGroupedByDay(
    viewModel: ActivitiesViewModel
) {
    LazyColumn {
        viewModel.groupedActivities.forEach {
            stickyHeader {
                val date = it.date
                Text(text = "date: ${date.dayOfMonth} ${date.month} ${date.year}")
            }
            it.activities.forEach {
                item {
                    Text(text = "activity: ${it.title}, time: ${it.dateTime}")
                }
            }
        }
    }
}
