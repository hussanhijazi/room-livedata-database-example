package com.hussan.roomdatabase.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
data class Category(
        @PrimaryKey(autoGenerate = true)
        var uid: Long,
        var name: String = ""
) {
    constructor() : this(-1, "")
}
