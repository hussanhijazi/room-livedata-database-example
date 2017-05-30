package com.hussan.roomdatabase.ui.products

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.hussan.roomdatabase.R


class ProductViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    var tvProductName: TextView = v.findViewById(R.id.tv_product_name) as TextView
    var btDelete: ImageView = v.findViewById(R.id.bt_delete) as ImageView
}