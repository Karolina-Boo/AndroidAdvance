package com.example.androidadvance.coordinatorlayouttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.androidadvance.R
import com.example.androidadvance.databinding.ActivityCoordinatorLayoutBinding
import com.example.androidadvance.tablayouttest.FragmentAdapter
import com.example.androidadvance.tablayouttest.ListFragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator

class CoordinatorLayoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoordinatorLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoordinatorLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val ab = supportActionBar
        ab!!.setDisplayHomeAsUpEnabled(true)
        initViewPager()
    }

    private fun initViewPager() {
        val titles = arrayListOf("巴萨","拜仁","皇马","尤文","大巴黎","曼联","汉堡")
        for (i in titles.indices) {
            binding.tabs.addTab(binding.tabs.newTab().setText(titles[i]))
        }
        val fragments = ArrayList<Fragment>()
        for (i in titles.indices) {
            fragments.add(ListFragment())
        }
        val fragmentAdapter = FragmentAdapter(this, fragments, titles)
        //给ViewPager设置适配器
        binding.viewpager.adapter = fragmentAdapter
        //将TabLayout和ViewPager关联起来
        TabLayoutMediator(binding.tabs,binding.viewpager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }

    fun checkin(view:View) {
        Snackbar.make(view,"点击成功",Snackbar.LENGTH_SHORT).show()
    }
}