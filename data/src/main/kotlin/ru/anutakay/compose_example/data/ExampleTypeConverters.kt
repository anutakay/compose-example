package ru.anutakay.compose_example.data

import java.time.Instant
import java.time.LocalDateTime
import java.util.*
import ru.anutakay.compose_example.data.entities.DbActivityNote
import ru.anutakay.compose_example.data.entities.DbEmotionNote
import ru.anutakay.compose_example.model.entities.Activity
import ru.anutakay.compose_example.model.entities.EmotionNote
import ru.anutakay.compose_example.model.entities.Emotion

object ExampleTypeConverters {

    @JvmStatic
    fun toDbEntity(modelEntity: Activity): DbActivityNote = DbActivityNote()
        .apply {
            title = modelEntity.title
            timestamp = toTimestamp(modelEntity.dateTime)
        }

    @JvmStatic
    fun toModelEntity(dbEntity: DbActivityNote): Activity = Activity(
        title = dbEntity.title ?: "UNKNOWN",
        dateTime = toLocalDateTime(dbEntity.timestamp)
    )

    @JvmStatic
    fun toDbEntity(modelEntity: EmotionNote): DbEmotionNote = DbEmotionNote()
        .apply {
            title = modelEntity.emotion.name.lowercase()
            timestamp = toTimestamp(modelEntity.dateTime)
        }

    @JvmStatic
    fun toModelEntity(dbEntity: DbEmotionNote): EmotionNote = EmotionNote(
        emotion = try {
            dbEntity.title
                ?.let {  Emotion.valueOf(it.uppercase()) }
                ?: Emotion.UNKNOWN
        } catch (e: IllegalArgumentException) { Emotion.UNKNOWN },
        dateTime = toLocalDateTime(dbEntity.timestamp)
    )

    @JvmStatic
    fun toLocalDateTime(it: Long): LocalDateTime = LocalDateTime.ofInstant(
        Instant.ofEpochMilli(it),
        TimeZone.getDefault().toZoneId()
    )

    @JvmStatic
    private fun toTimestamp(dateTime: LocalDateTime) = dateTime
        .atZone(TimeZone.getDefault().toZoneId())
        .toInstant().toEpochMilli()
}
