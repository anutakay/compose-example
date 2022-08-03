package ru.anutakay.compose_example.data

import ru.anutakay.compose_example.data.daos.ActivitiesDao

interface ExampleDatabase {
    fun activitiesDao(): ActivitiesDao
}
