package ru.anutakay.compose_example.data.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "emotion_notes")
class DbEmotionNote {
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    var id: Long = 0
    @ColumnInfo(name = "title") var title: String? = null
    @ColumnInfo(name = "timestamp") var timestamp = 0L
}
