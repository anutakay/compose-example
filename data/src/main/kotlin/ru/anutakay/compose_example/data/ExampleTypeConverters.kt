package ru.anutakay.compose_example.data

//import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.util.*
import ru.anutakay.compose_example.data.entities.DbActivity
import ru.anutakay.compose_example.model.entities.Activity

object ExampleTypeConverters {

   // @TypeConverter
    @JvmStatic
    fun toDbEntity(modelEntity: Activity): DbActivity = DbActivity()

    //@TypeConverter
    @JvmStatic
    fun toModelEntity(dbEntity: DbActivity): Activity = Activity(
        title = dbEntity.title ?: "UNKNOWN",
        dateTime = toLocalDateTime(dbEntity.timestamp)
    )

    @JvmStatic
    fun toLocalDateTime(it: Long): LocalDateTime = LocalDateTime.ofInstant(
        Instant.ofEpochMilli(it),
        TimeZone.getDefault().toZoneId()
    )
}
