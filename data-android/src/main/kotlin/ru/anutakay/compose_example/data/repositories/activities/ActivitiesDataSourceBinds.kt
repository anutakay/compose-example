package ru.anutakay.compose_example.data.repositories.activities

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.anutakay.compose_example.data.repositories.activities.db.DbActivitiesGroupedByDayDataSource
import ru.anutakay.compose_example.data.repositories.activities.db.DbAddActivityGateway
import ru.anutakay.compose_example.data.repositories.activities.db.DbAddEmotionNoteGateway
import ru.anutakay.compose_example.data.repositories.activities.generate.GenerateEmotionOptionsDataSource
import ru.anutakay.compose_example.data.repositories.activities.interfaces.ActivitiesGroupedByDayDataSource
import ru.anutakay.compose_example.data.repositories.activities.interfaces.AddActivityGateway
import ru.anutakay.compose_example.data.repositories.activities.interfaces.AddEmotionNoteGateway
import ru.anutakay.compose_example.data.repositories.activities.interfaces.EmotionOptionsDataSource

@InstallIn(SingletonComponent::class)
@Module
abstract class ActivitiesDataSourceBinds {

    @Binds
    abstract fun bindActivitiesGroupedByDayDataSource(
        source: DbActivitiesGroupedByDayDataSource
    ): ActivitiesGroupedByDayDataSource

    @Binds
    abstract fun bindAddActivityGateway(
        source: DbAddActivityGateway
    ): AddActivityGateway

    @Binds
    abstract fun bindAddEmotionNoteGateway(
        source: DbAddEmotionNoteGateway
    ): AddEmotionNoteGateway

    @Binds
    abstract fun bindEmotionOptionsDataSource(
        source: GenerateEmotionOptionsDataSource
    ): EmotionOptionsDataSource
}
