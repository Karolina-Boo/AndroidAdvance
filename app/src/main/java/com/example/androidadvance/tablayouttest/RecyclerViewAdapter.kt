package com.example.androidadvance.tablayouttest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidadvance.R

class RecyclerViewAdapter(val context: Context): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_card_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view = holder.itemView
        view.setOnClickListener {
            Toast.makeText(context, "奔跑在孤傲的路上", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return 10
    }
}