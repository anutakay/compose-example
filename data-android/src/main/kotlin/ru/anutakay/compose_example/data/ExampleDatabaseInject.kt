package ru.anutakay.compose_example.data

import android.content.Context
import android.os.Debug
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import ru.anutakay.compose_example.data.entities.DbActivity

@Module
@InstallIn(SingletonComponent::class)
object RoomDatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext
        context: Context
    ): ExampleRoomDatabase =
        Room.inMemoryDatabaseBuilder(context, ExampleRoomDatabase::class.java)
            .fallbackToDestructiveMigration()
            .apply {
             //   if (Debug.isDebuggerConnected()) {
                    allowMainThreadQueries()
             //   }
            }
            .build()
}

@InstallIn(SingletonComponent::class)
@Module
abstract class DatabaseModuleBinds {
    @Binds
    abstract fun bindExampleDatabase(database: ExampleRoomDatabase): ExampleDatabase
}
