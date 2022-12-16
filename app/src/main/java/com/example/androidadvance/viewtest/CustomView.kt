package com.example.androidadvance.viewtest

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Scroller

class CustomView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {
    private var lastX = 0
    private var lastY = 0
    private val scroller = Scroller(context)

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //获取手指触摸点的横坐标和纵坐标
        val x = event!!.x.toInt()
        val y = event.y.toInt()

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastX = x
                lastY = y
            }
            MotionEvent.ACTION_MOVE -> {
                //计算移动距离
                val offsetX = x - lastX
                val offsetY = y - lastY

                //调用layout方法来重新放置它的位置
//                layout(left + offsetX, top + offsetY, right + offsetX, bottom + offsetY)
//                //对left和right进行偏移
//                offsetLeftAndRight(offsetX)
//                //对top和bottom进行偏移
//                offsetTopAndBottom(offsetY)

                //LayoutParams 改变布局参数
//                val layoutParams = layoutParams as LinearLayout.LayoutParams
//                layoutParams.leftMargin = left + offsetX
//                layoutParams.topMargin = top + offsetY
//                setLayoutParams(layoutParams)

                //使用ViewGroup.MarginLayoutParams 改变布局参数
//                val layoutParams = layoutParams as ViewGroup.MarginLayoutParams
//                layoutParams.leftMargin = left + offsetX
//                layoutParams.topMargin = top + offsetY
//                setLayoutParams(layoutParams)

                //使用scrollTo和scrollBy移动View
//                (parent as View).scrollBy(-offsetX, -offsetY)

            }
        }
        return true
    }

    override fun computeScroll() {
        super.computeScroll()
        if (scroller.computeScrollOffset()) {
            (parent as View).scrollTo(scroller.currX, scroller.currY)
            invalidate()
        }
    }

    fun smoothScrollTo(destX: Int, destY: Int) {
        val scrollX = scrollX
        val delta = destX - scrollX
        scroller.startScroll(scrollX, 0, delta, 0, 2000)
        invalidate()
    }
}