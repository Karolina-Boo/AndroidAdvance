package com.example.androidadvance.viewtest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.TextView

class InvalidTextView(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatTextView(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    init {
        initDraw()
    }

    private fun initDraw() {
        paint.color = Color.RED
        paint.strokeWidth = 1.5f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val width = width
        val height = height
        canvas!!.drawLine(0f,(height / 2).toFloat(),width.toFloat(),(height / 2).toFloat(),paint)
    }
}