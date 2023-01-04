package com.example.androidadvance.viewtest

import android.content.Context
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.example.androidadvance.R
import com.example.androidadvance.databinding.CustomGroupViewBinding

class TitleBar(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs) {
    private val binding = CustomGroupViewBinding.inflate(LayoutInflater.from(getContext()), this, true)
    private var color = 0
    private var textColor = 0
    private var titleName: String

    init {
        val typedArray = context!!.obtainStyledAttributes(attrs, R.styleable.TitleBar)
        color = typedArray.getColor(R.styleable.TitleBar_title_bg,Color.BLUE)
        textColor = typedArray.getColor(R.styleable.TitleBar_title_text_color, Color.WHITE)
        titleName = typedArray.getString(R.styleable.TitleBar_title_text).toString()
        typedArray.recycle()
        initView()
    }

    private fun initView() {
        //设置背景颜色
        binding.layoutTitlebarRootlayout.setBackgroundColor(color)
        //设置标题文字颜色
        binding.tvTitlebarTitle.setTextColor(textColor)
        binding.tvTitlebarTitle.text = titleName
    }

    fun setTitle(titleName: String) {
        if (!TextUtils.isEmpty(titleName)) {
            binding.tvTitlebarTitle.text = titleName
        }
    }

    fun setLeftListener(onClickListener: OnClickListener) {
        binding.ivTitlebarLeft.setOnClickListener(onClickListener)
    }

    fun setRightListener(onClickListener: OnClickListener) {
        binding.ivTitlebarRight.setOnClickListener(onClickListener)
    }
}