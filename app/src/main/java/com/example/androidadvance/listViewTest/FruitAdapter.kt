package com.example.androidadvance.listViewTest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.androidadvance.R

class FruitAdapter(context: Context, private val resource: Int, objects: MutableList<Fruit>) :
    ArrayAdapter<Fruit>(context, resource, objects) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val fruit = getItem(position)
        //使用viewholder优化getview中反复使用View的findviewbyid()方法来获取控件实例
        var viewHolder : ViewHolder
        //提升ListView的运行效率: 使用convertview中的缓存布局，避免反复加载
        var view: View
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resource, parent, false)
            val fruitImage = view.findViewById<ImageView>(R.id.fruitImage)
            val fruitName = view.findViewById<TextView>(R.id.fruitName)
            viewHolder = ViewHolder(fruitImage, fruitName)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        viewHolder.fruitImage.setImageResource(fruit!!.imageId)
        viewHolder.fruitName.text = fruit.name
        return view
    }

    inner class ViewHolder(val fruitImage: ImageView, val fruitName: TextView)
}