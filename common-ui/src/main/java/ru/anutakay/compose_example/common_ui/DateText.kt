package ru.anutakay.compose_example.common_ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.time.LocalDate

@Composable
fun DateText(
    modifier: Modifier,
    date: LocalDate
) = Text(
    modifier = modifier,
    text = "${date.dayOfMonth} ${date.month} ${date.year}"
)
