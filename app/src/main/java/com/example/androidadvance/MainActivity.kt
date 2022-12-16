package com.example.androidadvance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidadvance.cardviewtest.CardViewTestActivity
import com.example.androidadvance.coordinatorlayouttest.CollapsingToolbarActivity
import com.example.androidadvance.coordinatorlayouttest.CoordinatorLayoutActivity
import com.example.androidadvance.listViewTest.ListViewTestActivity
import com.example.androidadvance.recyclerViewTest.RecyclerViewTestActivity
import com.example.androidadvance.tablayouttest.TabLayoutActivity
import com.example.androidadvance.textinputtest.TextInputActivity
import com.example.androidadvance.viewtest.CustomViewActivity

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
        val textInputButton = findViewById<Button>(R.id.btn_text_input)
        textInputButton.setOnClickListener {
            val intent = Intent(this, TextInputActivity::class.java)
            startActivity(intent)
        }
        val tabLayoutButton = findViewById<Button>(R.id.btn_tab_layout)
        tabLayoutButton.setOnClickListener {
            val intent = Intent(this, TabLayoutActivity::class.java)
            startActivity(intent)
        }
        val coordinatorLayoutButton = findViewById<Button>(R.id.btn_coordinator_layout)
        coordinatorLayoutButton.setOnClickListener {
            val intent = Intent(this, CoordinatorLayoutActivity::class.java)
            startActivity(intent)
        }
        val collapsingLayoutButton = findViewById<Button>(R.id.btn_collapsing_layout)
        collapsingLayoutButton.setOnClickListener {
            val intent = Intent(this, CollapsingToolbarActivity::class.java)
            startActivity(intent)
        }
        val customViewButton = findViewById<Button>(R.id.btn_custom_view)
        customViewButton.setOnClickListener {
            val intent = Intent(this,CustomViewActivity::class.java)
            startActivity(intent)
        }

    }
}