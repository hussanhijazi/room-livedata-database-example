package com.hussan.roomdatabase

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.hussan.roomdatabase.db.DatabaseCreator
import com.hussan.roomdatabase.db.entity.Category
import com.hussan.roomdatabase.db.entity.Product
import com.hussan.roomdatabase.ui.products.ProductAdapter
import com.hussan.roomdatabase.viewmodel.ProductListViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainActivity : LifecycleActivity() {

    lateinit var btInsert: Button
    lateinit var etProductName: EditText
    lateinit var rvProducts: RecyclerView
    lateinit var adapter: ProductAdapter

    lateinit var mShowProductViewModel: ProductListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btInsert = findViewById(R.id.bt_insert) as Button
        etProductName = findViewById(R.id.et_product_name) as EditText
        rvProducts = findViewById(R.id.rv_products) as RecyclerView

        setupRecyclerView()

        addCategory()

        mShowProductViewModel = ViewModelProviders.of(this).get(ProductListViewModel::class.java)
        mShowProductViewModel.products.observe(this@MainActivity, Observer { products ->
            Log.d("MainActivity", products?.size.toString())
            adapter.setItems(products)
        })

        btInsert.setOnClickListener { _ ->
            addProduct(etProductName.text.toString(), "Some description")
            etProductName.setText("")
        }

    }

    fun deleteClickListener(product: Product) {
        mShowProductViewModel.deleteProduct(product)
    }
    fun setupRecyclerView() {

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvProducts.layoutManager = layoutManager

        adapter = ProductAdapter(ArrayList(), this, this::deleteClickListener)
        rvProducts.adapter = adapter

        val dividerItemDecoration = DividerItemDecoration(rvProducts.context,
                layoutManager.orientation)
        rvProducts.addItemDecoration(dividerItemDecoration)
    }

    fun addCategory() {
        val category = Category(1, "Phone")
        Single.fromCallable {
            DatabaseCreator.database.categoryDao()?.insert(category)
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe()
    }

    fun addProduct(name: String, description: String) {
        val product = Product(0, 1, name, description)
        mShowProductViewModel.insert(product)
    }
}
