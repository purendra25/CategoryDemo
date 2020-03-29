package com.example.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adapter.ProductAdapter.ProductHolder
import com.example.categorydemo.R
import com.example.model.Product

class ProductAdapter(val context: Context, val productList: List<Product>, val itemClick:(Product)->Unit)

    : RecyclerView.Adapter<ProductHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.count()
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bindCategory(context,productList.get(position))
    }


    inner class ProductHolder( itemView:View): RecyclerView.ViewHolder(itemView){

        val productImage = itemView?.findViewById<ImageView>(R.id.productImage)
        val productName = itemView?.findViewById<TextView>(R.id.productName)
        val productPrice = itemView?.findViewById<TextView>(R.id.productPrice)

        fun bindCategory(context:Context,procut :Product){

            val resourceId = context.resources.getIdentifier(procut.image, "drawable", context.packageName)


            productImage.setImageResource(resourceId)
            productName.text = procut.title
            productPrice.text = procut.price

            itemView.setOnClickListener{
                itemClick(procut)
            }
        }
    }
}