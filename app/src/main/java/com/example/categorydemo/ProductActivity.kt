package com.example.categorydemo

import android.content.Intent
import android.content.res.Configuration
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Utilities.EXTRA_CATEGORY
import com.example.Utilities.EXTRA_PRODUCT
import com.example.adapter.CategoryAdapter
import com.example.adapter.ProductAdapter
import com.example.jonnyb.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_products.*

class ProductActivity : AppCompatActivity() {

    lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryData = intent.getStringExtra(EXTRA_CATEGORY)
        productAdapter = ProductAdapter(this,DataService.getProducts(categoryData)){
            val productDetailIntent = Intent(this, ProductDetailActvity::class.java)
            productDetailIntent.putExtra(EXTRA_PRODUCT, it)
            startActivity(productDetailIntent)
        }

        var spanCount = 2

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 3
        }

        if(resources.configuration.screenWidthDp >700){
            spanCount = 3
        }



        val layManger = GridLayoutManager(this,spanCount)
        productsListView.layoutManager = layManger
        productsListView.adapter = productAdapter



    }
}
