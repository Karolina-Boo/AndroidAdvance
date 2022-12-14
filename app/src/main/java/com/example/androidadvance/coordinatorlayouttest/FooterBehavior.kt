package com.example.androidadvance.coordinatorlayouttest

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.google.android.material.appbar.AppBarLayout
import kotlin.math.abs

class FooterBehavior(context: Context?, attrs: AttributeSet?) :
    CoordinatorLayout.Behavior<View>(context, attrs) {
    private var directionChange = 0

    /**
     * 表明这次滑动要不要关心，这里关心Y轴方向上的滑动
     */
    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        directTargetChild: View,
        target: View,
        nestedScrollAxes: Int
    ): Boolean {
        return nestedScrollAxes and ViewCompat.SCROLL_AXIS_VERTICAL != 0
    }


    /**
     * 用于处理滑动
     */
    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray
    ) {
        if (dy > 0 && directionChange < 0 || dy < 0 && directionChange > 0) {
            child.animate().cancel()
            directionChange = 0
        }
        directionChange += dy
        Log.d("footerbehavior","directionChange is $directionChange")
        if (directionChange > child.height && child.visibility == View.VISIBLE) {
            hide(child)

        } else if (directionChange < 0 && child.visibility == View.INVISIBLE) {
            show(child)
        }
    }

    private fun hide(view: View) {
        val animator = view.animate().translationY(view.height.toFloat())
            .setInterpolator(FastOutSlowInInterpolator()).setDuration(200)
        animator.setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animator: Animator) {
                view.visibility = View.INVISIBLE
            }
        })
        animator.start()
    }

    private fun show(view: View) {
        val animator = view.animate().translationY(0f).setInterpolator(FastOutSlowInInterpolator())
            .setDuration(200)
        animator.setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animator: Animator) {
                view.visibility = View.VISIBLE
            }
        })
        animator.start()
    }
}