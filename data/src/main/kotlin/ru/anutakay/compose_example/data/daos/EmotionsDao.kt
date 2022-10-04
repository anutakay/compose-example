package ru.anutakay.compose_example.data.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.rxjava3.core.Observable
import ru.anutakay.compose_example.data.entities.DbEmotionNote

@Dao
abstract class EmotionsDao {

    @Insert
    abstract fun addEmotionsNote(note: DbEmotionNote)

    @Query("SELECT * FROM emotion_notes")
    abstract fun getActivities(): Observable<List<DbEmotionNote>>
}
