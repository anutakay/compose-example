package ru.anutakay.compose_example.add_emotion_note

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import java.time.LocalDateTime
import ru.anutakay.compose_example.common_ui.SaveButtonBox
import ru.anutakay.compose_example.model.entities.Emotion
import ru.anutakay.compose_example.model.entities.EmotionNote

@ExperimentalMaterial3Api
@Composable
fun AddEmotionNote(navController: NavController) = AddEmotionNote(
    viewModel = androidx.hilt.navigation.compose.hiltViewModel(),
    navController = navController,
)

@ExperimentalMaterial3Api
@Composable
internal fun AddEmotionNote(
    viewModel: AddEmotionNoteViewModel,
    navController: NavController,
) {
    val selectedState = remember { mutableStateOf(Pair("", Emotion.UNKNOWN)) }
    val emotionOptions by viewModel.emotionOptions.subscribeAsState(listOf())

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            EmotionOptionsDropdown(selectedState, emotionOptions)
        }
    }

    SaveButtonBox(
        onButtonClick = {
            viewModel.addEmotionsNote(EmotionNote(selectedState.value.second, LocalDateTime.now()))
            navController.popBackStack()
        }
    )
}

@ExperimentalMaterial3Api
@Composable
private fun EmotionOptionsDropdown(
    selectedState: MutableState<Pair<String, Emotion>>,
    emotionOptions: List<Pair<String, Emotion>>
) {
    val expandedState = remember { mutableStateOf(false) }
    val textFieldSizeState = remember { mutableStateOf(Size.Zero) }

    OutlinedTextField(
        value = selectedState.value.first,
        onValueChange = {},
        trailingIcon = {
            Icon(dropdownMenuIcon(expandedState), "contentDescription",
                Modifier.clickable { expandedState.value = !expandedState.value })
        },
        modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned {
                textFieldSizeState.value = it.size.toSize()
            }
    )
    DropdownMenu(
        expanded = expandedState.value,
        onDismissRequest = {},
        modifier = Modifier
            .width(with(LocalDensity.current) { textFieldSizeState.value.width.toDp() })
            .wrapContentHeight()
    ) {
        emotionOptions.forEach { label ->
            DropdownMenuItem(
                onClick = {
                    selectedState.value = label
                    expandedState.value = false
                },
                text = { Text(text = label.first) }
            )
        }
    }
}
