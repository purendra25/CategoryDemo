package com.example.categorydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Utilities.EXTRA_CATEGORY
import com.example.adapter.CategoryAdapter
import com.example.jonnyb.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categoryAdapter = CategoryAdapter(this,DataService.categories){
           val intent = Intent(this,ProductActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY,it.title)
            startActivity(intent)
        }
        categoryListView.adapter = categoryAdapter
        val layManger = LinearLayoutManager(this)
        categoryListView.layoutManager = layManger
        categoryListView.setHasFixedSize(true)



    }
}
