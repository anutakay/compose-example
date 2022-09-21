package ru.anutakay.compose_example.data

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RoomDatabaseModule::class]
)
object FakeRoomDatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext
        context: Context
    ): ExampleRoomDatabase =
        Room.inMemoryDatabaseBuilder(context, ExampleRoomDatabase::class.java)
            .fallbackToDestructiveMigration()
            .build()
}
