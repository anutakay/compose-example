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
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.anutakay.compose_example.common_ui.DateText
import ru.anutakay.compose_example.common_ui.DateTimeText
import ru.anutakay.compose_example.model.entities.Activity
import ru.anutakay.compose_example.model.entities.DayActivities

@Composable
internal fun Activities(navController: NavController) = Activities(
    viewModel = hiltViewModel(),
    navController = navController,
)

@Composable
internal fun Activities(
    viewModel: ActivitiesViewModel,
    navController: NavController,
) {
    val state by viewModel.groupedActivities.subscribeAsState(listOf())
    LazyColumn(
        modifier = Modifier.padding(16.dp).testTag(ActivitiesTags.LIST)
    ) { state.forEach { item { DayCard(it) } } }
}

@Composable
private fun DayCard(
    dayActivities: DayActivities
) {
    Card(
        modifier = Modifier.padding(10.dp).testTag(ActivitiesTags.DAY_CARD),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.surface)
        ) {
            DateText(
                Modifier.wrapContentWidth().testTag(ActivitiesTags.DATE),
                date = dayActivities.date
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            dayActivities.activities.forEach { ActivityItem(it) }
        }
    }
}


@Composable
private fun ActivityItem(activity: Activity) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .testTag(ActivitiesTags.ACTIVITY_ITEM),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.wrapContentWidth().testTag(ActivitiesTags.TITLE),
            text = activity.title
        )
        DateTimeText(
            modifier = Modifier.wrapContentWidth().testTag(ActivitiesTags.TIME),
            dateTime = activity.dateTime
        )
    }
}

object ActivitiesTags {
    const val LIST = "ActivitiesTags:LIST"
    const val DAY_CARD = "ActivitiesTags:DAY_CARD"
    const val ACTIVITY_ITEM = "ActivitiesTags:ACTIVITY_ITEM"
    const val DATE =  "ActivitiesTags:DATE"
    const val TIME =  "ActivitiesTags:TIME"
    const val TITLE =  "ActivitiesTags:TITLE"
}
