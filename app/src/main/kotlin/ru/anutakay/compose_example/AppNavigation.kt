package ru.anutakay.compose_example

internal sealed class Screen(val route: String) {
    object Activities : Screen("activities")
    object AddActivity : Screen("add_activity")
}
