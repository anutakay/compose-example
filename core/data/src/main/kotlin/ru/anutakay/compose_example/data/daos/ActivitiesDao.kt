package ru.anutakay.compose_example.data.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.rxjava3.core.Observable
import ru.anutakay.compose_example.data.entities.DbActivityNote

@Dao
abstract class ActivitiesDao {

    @Insert
    abstract fun addActivityNote(activity: DbActivityNote)

    @Query("SELECT * FROM activities")
    abstract fun getActivities(): Observable<List<DbActivityNote>>
}
