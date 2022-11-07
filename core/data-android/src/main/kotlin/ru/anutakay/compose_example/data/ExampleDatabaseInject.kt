package ru.anutakay.compose_example.data

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext
        context: Context
    ): ExampleRoomDatabase =
        Room.databaseBuilder(context, ExampleRoomDatabase::class.java, "example_database")
            .fallbackToDestructiveMigration()
            .build()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModuleBinds {
    @Binds
    abstract fun bindExampleDatabase(database: ExampleRoomDatabase): ExampleDatabase
}
