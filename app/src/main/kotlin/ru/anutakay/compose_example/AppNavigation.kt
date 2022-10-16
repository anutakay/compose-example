package ru.anutakay.compose_example

internal sealed class Screen(val route: String) {
    object Activities : Screen("activities")
    object AddActivity : Screen("add_activity")
    object AddEmotionNote : Screen ("add_emotion_note")
}
