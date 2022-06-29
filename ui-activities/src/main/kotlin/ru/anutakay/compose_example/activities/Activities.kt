package ru.anutakay.compose_example.activities

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.anutakay.compose_example.data.entities.Activity
import ru.anutakay.compose_example.data.entities.DayActivities

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
    Surface {
        ActivitiesGroupedByDay(viewModel)
    }
}

@Composable
private fun ActivitiesGroupedByDay(
    viewModel: ActivitiesViewModel
) {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        viewModel.groupedActivities.forEach { item { DayCard(it) } }
    }
}

@Composable
private fun DayCard(
    it: DayActivities
) {
    Card(
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .background(MaterialTheme.colors.surface)
        ) {
            DateText(it)
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            it.activities.forEach { ActivityRow(it) }
        }
    }
}

@Composable
private fun DateText(it: DayActivities) {
    Text(text = "${it.date.dayOfMonth} ${it.date.month} ${it.date.year}")
}

@Composable
private fun ActivityRow(it: Activity) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.wrapContentWidth(),
            text = it.title
        )
        Text(
            modifier = Modifier.wrapContentWidth(),
            text = "${it.dateTime.hour}:${it.dateTime.minute}"
        )
    }
}
