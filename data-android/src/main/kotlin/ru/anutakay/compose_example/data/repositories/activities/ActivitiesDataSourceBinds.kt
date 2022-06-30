package ru.anutakay.compose_example.data.repositories.activities

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.anutakay.compose_example.data.repositories.activities.debug.DebugActivitiesGroupedByDayDataSource

@InstallIn(SingletonComponent::class)
@Module
abstract class ActivitiesDataSourceBinds {

    @Binds
    abstract fun bindActivitiesGroupedByDayDataSource(
        source: DebugActivitiesGroupedByDayDataSource
    ): ActivitiesGroupedByDayDataSource
}
