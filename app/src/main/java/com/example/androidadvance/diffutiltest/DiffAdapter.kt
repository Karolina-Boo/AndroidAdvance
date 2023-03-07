package com.example.androidadvance.diffutiltest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidadvance.R

class DiffAdapter(context: Context, var datas: ArrayList<TestBean>): RecyclerView.Adapter<DiffAdapter.DiffVH>() {
    companion object {
        private const val TAG = "nty"
    }

    private var inflater : LayoutInflater? = null

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiffVH {
        return DiffVH(inflater!!.inflate(R.layout.item_diff, parent, false))
    }

    override fun getItemCount(): Int {
        return datas.size ?: 0
    }

    override fun onBindViewHolder(holder: DiffVH, position: Int) {
        val bean = datas[position]
        holder.tv1.text = bean.name
        holder.tv2.text = bean.desc
        holder.iv.setImageResource(bean.picSrc)
    }

    class DiffVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv1 = itemView.findViewById<TextView>(R.id.tv_1)!!
        val tv2 = itemView.findViewById<TextView>(R.id.tv_2)!!
        val iv = itemView.findViewById<ImageView>(R.id.iv)!!
    }
}