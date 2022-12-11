package com.example.androidadvance.recyclerViewTest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DividerGridItemDecoration(): RecyclerView.ItemDecoration() {
    companion object {
        val ATTRS = intArrayOf(android.R.attr.listDivider)
    }

    private lateinit var mDivider: Drawable
    private var mColumns = 0

    constructor(context: Context, columns: Int) : this() {
        val a = context.obtainStyledAttributes(ATTRS)
        mDivider = a.getDrawable(0)!!
        a.recycle()
        setColumns(columns)
    }

    private fun setColumns(columns: Int) {
        mColumns = columns
    }

    override fun onDraw(c: Canvas, parent: RecyclerView) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val childCount = parent.childCount
        for (i in 0 until childCount step(mColumns + 1)) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider.intrinsicHeight
            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(c)
        }
    }

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        outRect.set(0,0,0,mDivider.intrinsicHeight)
    }
}