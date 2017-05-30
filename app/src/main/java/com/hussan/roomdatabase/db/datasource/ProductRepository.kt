package com.hussan.roomdatabase.db.datasource

import android.arch.lifecycle.LiveData
import com.hussan.roomdatabase.db.entity.Product
import io.reactivex.Completable

interface ProductRepository {
    fun addProduct(product: Product): Completable

    fun getProducts(): LiveData<List<Product>>

    fun deleteProduct(product: Product): Completable
}