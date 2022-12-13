package com.example.androidadvance.tablayouttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.androidadvance.R
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar
        ab!!.setHomeAsUpIndicator(R.drawable.ic_menu)
        ab.setDisplayHomeAsUpEnabled(true)
        viewPager = findViewById(R.id.viewpager)
        drawerLayout = findViewById(R.id.dl_main_drawer)
        val navigationView = findViewById<NavigationView>(R.id.nv_main_navigation)
        navigationView?.setNavigationItemSelectedListener {
            it.isChecked = true
            val title = it.title.toString()
            Toast.makeText(applicationContext, title, Toast.LENGTH_SHORT).show()
            //关闭导航菜单
            drawerLayout.closeDrawers()
            return@setNavigationItemSelectedListener true
        }
        initViewPager()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initViewPager() {
        tabLayout = findViewById(R.id.tabs)
        val titles = arrayListOf("巴萨","拜仁","皇马","尤文")
        for (i in titles.indices) {
            tabLayout.addTab(tabLayout.newTab().setText(titles[i]))
        }
        val fragments = ArrayList<Fragment>()
        for (i in titles.indices) {
            fragments.add(ListFragment())
        }
        val fragmentAdapter = FragmentAdapter(this, fragments, titles)
        //给ViewPager设置适配器
        viewPager.adapter = fragmentAdapter
        //将TabLayout和ViewPager关联起来
        TabLayoutMediator(tabLayout,viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }
}