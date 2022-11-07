package ru.anutakay.compose_example.add_emotion_note

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.State

fun dropdownMenuIcon(isExpanded: State<Boolean>) =
    if (isExpanded.value)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
