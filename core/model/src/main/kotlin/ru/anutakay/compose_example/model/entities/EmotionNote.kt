package ru.anutakay.compose_example.model.entities

import java.time.LocalDateTime

data class EmotionNote(
    val emotion: Emotion,
    val dateTime: LocalDateTime
)
