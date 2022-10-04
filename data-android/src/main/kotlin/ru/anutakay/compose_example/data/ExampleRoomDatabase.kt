package ru.anutakay.compose_example.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.anutakay.compose_example.data.entities.DbActivityNote
import ru.anutakay.compose_example.data.entities.DbEmotionNote

@Database(
    entities = [
        DbActivityNote::class,
        DbEmotionNote::class
    ],
    version = 2
)
//@TypeConverters(ExampleTypeConverters::class)
abstract class ExampleRoomDatabase : RoomDatabase(), ExampleDatabase
