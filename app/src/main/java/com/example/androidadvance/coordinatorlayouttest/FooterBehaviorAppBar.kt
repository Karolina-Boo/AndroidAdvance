package com.example.androidadvance.coordinatorlayouttest

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import kotlin.math.abs

class FooterBehaviorAppBar(context: Context, attrs: AttributeSet):
    CoordinatorLayout.Behavior<View>(context, attrs) {
    /**
     * 返回我们需要关心的类
     */
    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return dependency is AppBarLayout
    }

    /**
     * 根据我们关心的View的变化来对设置Behavior的View进行一系列处理
     */
    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        val translationY = abs(dependency.y)
        child.translationY = translationY
        return true
    }
}