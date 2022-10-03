package ru.anutakay.compose_example.common_ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.time.LocalDateTime

@Composable
fun DateTimeText(
    modifier: Modifier,
    dateTime: LocalDateTime
) = Text(
    modifier = modifier,
    text = "${dateTime.hour}:${dateTime.minute}"
)