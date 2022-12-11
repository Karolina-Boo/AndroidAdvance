package com.example.androidadvance.recyclerViewTest

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidadvance.listViewTest.Fruit
import com.example.androidadvance.R
import java.util.*
import kotlin.collections.ArrayList

class RecyclerViewTestActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_test)
        initFruits()
        val recyclerView = findViewById<RecyclerView>(R.id.rv_fruit)
//        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapterRecyclerView(fruitList)
//        adapter.setOnItemClickListener(object : FruitAdapterRecyclerView.OnItemClickListener {
//            override fun onItemClick(view: View, position: Int) {
//                Toast.makeText(this@RecyclerViewTestActivity,"点击第${position + 1}条", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onItemLongClick(view: View, position: Int) {
//                AlertDialog.Builder(this@RecyclerViewTestActivity)
//                    .setTitle("确认删除吗？")
//                    .setNegativeButton("取消", null)
//                    .setPositiveButton("确定", DialogInterface.OnClickListener{_, _ ->
//                        adapter.notifyItemRemoved(position)
//                    }).show()
//            }
//
//        })
//        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST))
        recyclerView.adapter = adapter
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
        //瀑布流
//        repeat(2) {
//            fruitList.add(Fruit(getRandomLengthName("Apple"), R.mipmap.apple_pic))
//            fruitList.add(Fruit(getRandomLengthName("Banana"), R.mipmap.banana_pic))
//            fruitList.add(Fruit(getRandomLengthName("Orange"), R.mipmap.orange_pic))
//            fruitList.add(Fruit(getRandomLengthName("Watermelon"), R.mipmap.watermelon_pic))
//            fruitList.add(Fruit(getRandomLengthName("Pear"), R.mipmap.pear_pic))
//            fruitList.add(Fruit(getRandomLengthName("Grape"), R.mipmap.grape_pic))
//            fruitList.add(Fruit(getRandomLengthName("Pineapple"), R.mipmap.pineapple_pic))
//            fruitList.add(Fruit(getRandomLengthName("Strawberry"), R.mipmap.strawberry_pic))
//            fruitList.add(Fruit(getRandomLengthName("Cherry"), R.mipmap.cherry_pic))
//            fruitList.add(Fruit(getRandomLengthName("Mango"), R.mipmap.mango_pic))
//        }
    }

    private fun getRandomLengthName(name: String) : String{
        val length = Random().nextInt(20) + 1
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(name)
        }
        return builder.toString()

    }
}