package ru.anutakay.compose_example.data.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import io.reactivex.rxjava3.core.Observable
import ru.anutakay.compose_example.data.entities.DbActivity

@Dao
abstract class ActivitiesDao {

    @Query("SELECT * FROM dbActivity")
    abstract fun getActivities(): List<DbActivity>
}
