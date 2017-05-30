package com.hussan.roomdatabase.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.IGNORE
import android.arch.persistence.room.Query
import com.hussan.roomdatabase.db.entity.Category

@Dao
interface CategoryDAO{

    @Query("SELECT * FROM category")
    fun getAllCategories(): io.reactivex.Flowable<List<Category>>

    @Insert(onConflict = IGNORE)
    fun insert(category: Category)
}
