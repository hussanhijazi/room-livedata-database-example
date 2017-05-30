package com.hussan.roomdatabase.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.hussan.roomdatabase.db.dao.CategoryDAO
import com.hussan.roomdatabase.db.dao.ProductDAO
import com.hussan.roomdatabase.db.entity.Category
import com.hussan.roomdatabase.db.entity.Product

@Database(entities = arrayOf(Product::class, Category::class), version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDAO
    abstract fun categoryDao(): CategoryDAO
}