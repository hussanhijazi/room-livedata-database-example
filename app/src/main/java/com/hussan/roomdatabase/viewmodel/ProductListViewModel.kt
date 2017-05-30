package com.hussan.roomdatabase.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.util.Log
import com.hussan.roomdatabase.db.DatabaseCreator
import com.hussan.roomdatabase.db.datasource.ProductRepository
import com.hussan.roomdatabase.db.datasource.ProductRepositoryImpl
import com.hussan.roomdatabase.db.entity.Product
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class ProductListViewModel constructor(app: Application) : AndroidViewModel(app) {
    var productRepository: ProductRepository = ProductRepositoryImpl(DatabaseCreator.database)

    var products: LiveData<List<Product>> = productRepository.getProducts()

//    fun getProducts(): LiveData<List<Product>>
//    {
//        return items
//    }

    fun deleteProduct(product: Product) {
        productRepository.deleteProduct(product)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : CompletableObserver {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onComplete() {
                        Log.d("ProductListViewModel", "onComplete - deleted product")
                    }

                    override fun onError(e: Throwable) {
                        Log.e("ProductListViewModel", "OnError - deleted product: ", e)
                    }
                })
    }

    fun insert(product: Product) {
        productRepository.addProduct(product)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("ProductListViewModel", "Product Inserted")
                })
    }

}