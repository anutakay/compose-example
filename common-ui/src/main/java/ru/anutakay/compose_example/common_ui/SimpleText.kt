package ru.anutakay.compose_example.common_ui

import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun SimpleText(
    testTag: String,
    text: String
) = Text(
    modifier = Modifier
        .testTag(testTag)
        .wrapContentWidth(),
    text = text
)
