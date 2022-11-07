package ru.anutakay.compose_example.activities

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun DayCard(
    testTag: String,
    content: @Composable (ColumnScope.() -> Unit),
    onClick: () -> Unit = {}
) = ElevatedCard(
    modifier = Modifier.testTag(testTag).padding(vertical = 8.dp),
    onClick = onClick
) {
    Column(
        modifier = Modifier.padding(16.dp),
        content = content
    )
}

@Composable
internal fun ActivityRow(
    testTag: String,
    content: @Composable (RowScope.() -> Unit)
) = Row(
    modifier = Modifier
        .testTag(testTag)
        .fillMaxWidth()
        .padding(vertical = 8.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    content = content,
)
