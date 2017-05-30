package com.hussan.roomdatabase.db.datasource

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.hussan.roomdatabase.db.MyDatabase
import com.hussan.roomdatabase.db.entity.Product
import io.reactivex.Completable


/**
 * Created by hussan on 5/23/17.
 */

class ProductRepositoryImpl(val myDatabase: MyDatabase?) : ProductRepository {
    override fun getProducts(): LiveData<List<Product>> {
        return myDatabase?.productDao()?.getAllProducts() ?: MutableLiveData<List<Product>>()
    }

    override fun addProduct(product: Product): Completable {
        return Completable.fromAction { myDatabase?.productDao()?.insert(product) }
    }

    override fun deleteProduct(product: Product): Completable {
        return Completable.fromAction { myDatabase?.productDao()?.delete(product) }
    }
}