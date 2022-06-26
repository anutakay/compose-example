package ru.anutakay.compose_example.data.repositories.activities

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class ActivitiesDataSourceBinds {

    @Binds
    abstract fun bindDebugActivitiesFeedDataSource(
        source: DebugActivitiesFeedDataSource
    ): ActivitiesFeedDataSource
}
