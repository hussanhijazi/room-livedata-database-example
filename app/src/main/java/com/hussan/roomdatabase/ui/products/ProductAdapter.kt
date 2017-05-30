package com.hussan.roomdatabase.ui.products

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hussan.roomdatabase.db.entity.Product


class ProductAdapter(private var items: List<Product>?,
                     private val context: Context,
                     private val deleteClickListener: (Product) -> Unit) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ProductViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(com.hussan.roomdatabase.R.layout.list_item_product, parent, false)
        return ProductViewHolder(v)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = items!![position]
        holder.tvProductName.text = item.name
        holder.btDelete.setOnClickListener {
            deleteClickListener.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

    internal fun setItems(products: List<Product>?) {
        this.items = products
        notifyDataSetChanged()
    }

}