package ru.anutakay.compose_example.data

import ru.anutakay.compose_example.data.daos.ActivitiesDao
import ru.anutakay.compose_example.data.daos.EmotionsDao

interface ExampleDatabase {
    fun activitiesDao(): ActivitiesDao
    fun emotionsDao(): EmotionsDao
}
