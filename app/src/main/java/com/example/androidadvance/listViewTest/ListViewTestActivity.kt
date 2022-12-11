package com.example.androidadvance.listViewTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.androidadvance.R

class ListViewTestActivity : AppCompatActivity() {

    private val data = arrayOf("Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
        "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango")

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)
        initFruits()
        var fruitAdapter = FruitAdapter(
            this, R.layout.fruit_item, fruitList
        )
        val listView = findViewById<ListView>(R.id.list_view)
        listView.adapter = fruitAdapter
        listView.setOnItemClickListener { _, _, i, _ ->
            val fruit = fruitList[i]
            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initFruits() {
        repeat(2) {
            fruitList.add(Fruit("Apple", R.mipmap.apple_pic))
            fruitList.add(Fruit("Banana", R.mipmap.banana_pic))
            fruitList.add(Fruit("Orange", R.mipmap.orange_pic))
            fruitList.add(Fruit("Watermelon", R.mipmap.watermelon_pic))
            fruitList.add(Fruit("Pear", R.mipmap.pear_pic))
            fruitList.add(Fruit("Grape", R.mipmap.grape_pic))
            fruitList.add(Fruit("Pineapple", R.mipmap.pineapple_pic))
            fruitList.add(Fruit("Strawberry", R.mipmap.strawberry_pic))
            fruitList.add(Fruit("Cherry", R.mipmap.cherry_pic))
            fruitList.add(Fruit("Mango", R.mipmap.mango_pic))
        }
    }
}