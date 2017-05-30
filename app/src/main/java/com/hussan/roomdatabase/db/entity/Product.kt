package com.hussan.roomdatabase.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = arrayOf(ForeignKey(entity = Category::class,
        parentColumns = arrayOf("uid"),
        childColumns = arrayOf("categoryId"),
        onDelete = ForeignKey.CASCADE)))

data class Product(
        @PrimaryKey(autoGenerate = true)
        var uid: Long,
        var categoryId: Long,
        var name: String = "",
        var description: String = ""

) {
    constructor() : this(-1, -1, "", "")
}

