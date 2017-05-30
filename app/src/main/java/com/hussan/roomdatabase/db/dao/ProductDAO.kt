package com.hussan.roomdatabase.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.hussan.roomdatabase.db.entity.Product

@Dao
interface ProductDAO{

    @Query("SELECT * FROM product order by uid desc")
    fun getAllProducts(): LiveData<List<Product>>

    @Insert(onConflict = REPLACE)
    fun insert(product: Product)

    @Delete
    fun delete(product: Product)
}
