package ru.anutakay.compose_example.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class DbActivity {
    @PrimaryKey
    var id: Long = 0
    var title: String? = null
    var timestamp = 0L
}
