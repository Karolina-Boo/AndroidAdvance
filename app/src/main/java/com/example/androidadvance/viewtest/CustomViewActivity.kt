package com.example.androidadvance.viewtest

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.example.androidadvance.R

class CustomViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)
        val customView = this.findViewById<CustomView>(R.id.custom_view)
        //View动画
//        customView.animation = AnimationUtils.loadAnimation(this, R.anim.translate)
        //属性动画
//        ObjectAnimator.ofFloat(customView,"translationX",0f,300f).setDuration(1000).start()
        //使用scroller平滑滚动
//        customView.smoothScrollTo(-400,0)

        //属性动画之ObjectAnimator
//        val myView = MyView(customView)
//        ObjectAnimator.ofInt(myView,"width", 500).setDuration(500).start()

        //属性动画之ValueAnimator
//        val valueAnimator = ValueAnimator.ofFloat(0f,100f)
//        valueAnimator.setTarget(customView)
//        valueAnimator.setDuration(1000).start()
//        valueAnimator.addUpdateListener {
//            val float = it.animatedValue as Float
//        }

        //组合动画之AnimatorSet
//        val anim1 = ObjectAnimator.ofFloat(customView,"translationX",0.0f,200.0f,0f)
//        val anim2 = ObjectAnimator.ofFloat(customView,"scaleX",1.0f,2.0f)
        val anim3 = ObjectAnimator.ofFloat(customView,"rotationX",0.0f,90.0f,0.0f)
//        val set = AnimatorSet()
//        set.duration = 1000
//        set.play(anim1).with(anim2).after(anim3)
//        set.start()

        //组合动画之PropertyValuesHolder
//        val valuesHolder1 = PropertyValuesHolder.ofFloat("scaleX",1.0f,1.5f)
//        val valuesHolder2 = PropertyValuesHolder.ofFloat("rotationX",0.0f,90.0f,0.0f)
//        val valuesHolder3 = PropertyValuesHolder.ofFloat("alpha",1.0f,0.3f,1.0f)
//        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(customView,valuesHolder1, valuesHolder2,valuesHolder3)
//        objectAnimator.setDuration(2000).start()

        //在XML中使用属性动画
        val animator = AnimatorInflater.loadAnimator(this,R.animator.scale)
        animator.setTarget(customView)
        animator.start()
    }

    /**
     * ObjectAnimator 通过静态工厂类直接返还一个ObjectAnimator对象，要添加动画效果的对象属性必须具有 setter,getter 方法
     * 此处操作的属性为“width”
     */
    class MyView(private val target: View) {
        fun getWidth(): Int {
            return target.layoutParams.width
        }
        fun setWidth(width: Int) {
            target.layoutParams.width = width
            target.requestLayout()
        }
    }
}