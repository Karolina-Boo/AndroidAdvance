package com.example.androidadvance.recyclerViewTest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidadvance.listViewTest.Fruit
import com.example.androidadvance.R
import com.google.android.material.transition.Hold

class FruitAdapterRecyclerView(private val fruitList: List<Fruit>) : RecyclerView.Adapter<FruitAdapterRecyclerView.ViewHolder>(),
    View.OnClickListener, View.OnLongClickListener {

    private lateinit var mOnItemClickListener: OnItemClickListener
    private var  mHeights = ArrayList<Int>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        val viewHolder = ViewHolder(view)
        view.setOnClickListener(this)
        view.setOnLongClickListener(this)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "you clicked view ${fruit.name}", Toast.LENGTH_SHORT).show()
        }
        viewHolder.fruitImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "you clicked image ${fruit.name}", Toast.LENGTH_SHORT).show()
        }
        setHeights()
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.text = fruit.name
        val lp = holder.fruitName.layoutParams
        lp.height = mHeights[position]
        holder.fruitName.layoutParams = lp
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    fun setOnItemClickListener(mOnItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener
    }

    private fun setHeights() {
        for (i in fruitList.indices) {
            mHeights.add((100 + Math.random() * 300).toInt())
        }
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
        fun onItemLongClick(view: View, position: Int)
    }

    override fun onClick(view: View?) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view!!, view.tag as Int)
        }
    }

    override fun onLongClick(view: View?): Boolean {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemLongClick(view!!, view.tag as Int)
        }
        return true
    }
}
