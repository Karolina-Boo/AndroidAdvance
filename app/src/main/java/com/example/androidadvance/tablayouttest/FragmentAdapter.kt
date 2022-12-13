package com.example.androidadvance.tablayouttest

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fa: FragmentActivity, private val fragments: List<Fragment>, private val titles: List<String>) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}