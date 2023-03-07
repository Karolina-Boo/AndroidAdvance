package com.example.androidadvance.diffutiltest

import androidx.recyclerview.widget.DiffUtil

class DiffCallBack(
    private var oldDatas: List<TestBean>?,
    private var newDatas: List<TestBean>?
    ) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return if (oldDatas != null) oldDatas!!.size else 0
    }

    override fun getNewListSize(): Int {
        return if (newDatas != null) newDatas!!.size else 0
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldDatas!![oldItemPosition].name == newDatas!![newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val beanOld = oldDatas!![oldItemPosition]
        val beanNew = newDatas!![newItemPosition]
        if (beanOld.desc != beanNew.desc) {
            return false
        }
        if (beanOld.picSrc != beanNew.picSrc) {
            return false
        }
        return true
    }
}