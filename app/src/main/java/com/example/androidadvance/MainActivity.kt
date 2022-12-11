package com.example.androidadvance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidadvance.cardviewtest.CardViewTestActivity
import com.example.androidadvance.listViewTest.ListViewTestActivity
import com.example.androidadvance.recyclerViewTest.RecyclerViewTestActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listViewButton = findViewById<Button>(R.id.btn_list_view)
        listViewButton.setOnClickListener {
            val intent = Intent(this, ListViewTestActivity::class.java)
            startActivity(intent)
        }
        val recyclerViewButton = findViewById<Button>(R.id.btn_recycler_view)
        recyclerViewButton.setOnClickListener {
            val intent = Intent(this, RecyclerViewTestActivity::class.java)
            startActivity(intent)
        }
        val cardViewButton = findViewById<Button>(R.id.btn_card_view)
        cardViewButton.setOnClickListener {
            val intent = Intent(this, CardViewTestActivity::class.java)
            startActivity(intent)
        }
    }
}