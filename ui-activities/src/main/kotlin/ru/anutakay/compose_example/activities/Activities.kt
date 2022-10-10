package ru.anutakay.compose_example.activities

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.anutakay.compose_example.common_ui.SimpleText
import ru.anutakay.compose_example.model.entities.DayActivities
import ru.anutakay.compose_example.model.mappers.presentDate
import ru.anutakay.compose_example.model.mappers.presentTime

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
    val activitiesByDay by viewModel.groupedActivities.subscribeAsState(listOf())
    LazyColumn(
        modifier = Modifier
        .testTag(ActivitiesTags.LIST)
        .padding(16.dp)
    ) {
        activitiesByDay.forEach { item { DayActivitiesCard(it) } }
    }
}

@Composable
private fun DayActivitiesCard(dayActivities: DayActivities) = DayCard(
    testTag = ActivitiesTags.DAY_CARD,
    {
        SimpleText(
            testTag = ActivitiesTags.DATE,
            text = presentDate(dayActivities.date)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
        dayActivities.activities.forEach { activity ->
            ActivityRow(testTag = ActivitiesTags.ACTIVITY_ITEM) {
                SimpleText(
                    testTag = ActivitiesTags.TITLE,
                    text = activity.title
                )
                SimpleText(
                    testTag = ActivitiesTags.TIME,
                    text = presentTime(activity.dateTime)
                )
            }
        }
    },
)

object ActivitiesTags {
    const val LIST = "ActivitiesTags:LIST"
    const val DAY_CARD = "ActivitiesTags:DAY_CARD"
    const val ACTIVITY_ITEM = "ActivitiesTags:ACTIVITY_ITEM"
    const val DATE = "ActivitiesTags:DATE"
    const val TIME = "ActivitiesTags:TIME"
    const val TITLE = "ActivitiesTags:TITLE"
}
