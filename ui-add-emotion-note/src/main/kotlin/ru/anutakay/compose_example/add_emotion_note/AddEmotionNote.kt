package ru.anutakay.compose_example.add_emotion_note

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
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
    val mSelected = remember { mutableStateOf(Pair("", Emotion.UNKNOWN)) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            CitiesDropdown(mSelected, viewModel)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomCenter,
    ) {
        SaveButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            mSelected = mSelected,
            viewModel = viewModel,
            navController = navController
        )
    }
}

@ExperimentalMaterial3Api
@Composable
private fun CitiesDropdown(
    mSelected: MutableState<Pair<String, Emotion>>,
    viewModel: AddEmotionNoteViewModel
) {
    val isExpanded = remember { mutableStateOf(false) }
    val mTextFieldSize = remember { mutableStateOf(Size.Zero) }
    val emotionOptions by viewModel.emotionOptions.subscribeAsState(listOf())

    OutlinedTextField(
        value = mSelected.value.first,
        onValueChange = {},
        trailingIcon = {
            Icon(icon(isExpanded), "contentDescription",
                Modifier.clickable { isExpanded.value = !isExpanded.value })
        },
        modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned {
                mTextFieldSize.value = it.size.toSize()
            }
    )
    DropdownMenu(
        expanded = isExpanded.value,
        onDismissRequest = {},
        modifier = Modifier
            .width(with(LocalDensity.current) { mTextFieldSize.value.width.toDp() })
            .wrapContentHeight()
    ) {
        emotionOptions.forEach { label ->
            DropdownMenuItem(
                onClick = {
                    mSelected.value = label
                    isExpanded.value = false
                },
                text = { Text(text = label.first) }
            )
        }
    }
}

@Composable
private fun icon(isExpanded: State<Boolean>) =
    if (isExpanded.value)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

@Composable
private fun SaveButton(
    modifier: Modifier,
    mSelected: MutableState<Pair<String, Emotion>>,
    viewModel: AddEmotionNoteViewModel,
    navController: NavController
) = Button(
        modifier = modifier,
        onClick = {
            viewModel.addEmotionsNote(EmotionNote(mSelected.value.second, LocalDateTime.now()))
            navController.popBackStack()
        }
    ) {
        Text(text = "SAVE")
    }
