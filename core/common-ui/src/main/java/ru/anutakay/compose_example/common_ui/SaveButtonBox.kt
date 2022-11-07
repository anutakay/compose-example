package ru.anutakay.compose_example.common_ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SaveButtonBox(
    onButtonClick: () -> Unit = {}
) = Box(
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
    contentAlignment = Alignment.BottomCenter,
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        onClick = onButtonClick
    ) {
        Text(text = "SAVE")
    }
}
