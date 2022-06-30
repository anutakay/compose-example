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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.anutakay.compose_example.data.entities.Activity
import ru.anutakay.compose_example.data.entities.DayActivities
import java.time.LocalDate

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
    val state by viewModel.groupedActivities.subscribeAsState(listOf())
    Surface {
        ActivitiesGroupedByDay(state)
    }
}

@Composable
private fun ActivitiesGroupedByDay(state: List<DayActivities>) {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        state.forEach { item { DayCard(it) } }
    }
}

@Composable
private fun DayCard(
    dayActivities: DayActivities
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
            DateText(dayActivities.date)
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            dayActivities.activities.forEach { ActivityRow(it) }
        }
    }
}

@Composable
private fun DateText(date: LocalDate) {
    Text(text = "${date.dayOfMonth} ${date.month} ${date.year}")
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
