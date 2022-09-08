package ru.anutakay.compose_example.data.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "activities")
class DbActivity {
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    var id: Long = 0
    @ColumnInfo(name = "title") var title: String? = null
    @ColumnInfo(name = "timestamp") var timestamp = 0L
}
