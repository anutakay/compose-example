package ru.anutakay.compose_example.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.anutakay.compose_example.data.entities.DbActivity

@Database(
    entities = [
        DbActivity::class
    ],
    version = 1
)
abstract class ExampleRoomDatabase : RoomDatabase(), ExampleDatabase
