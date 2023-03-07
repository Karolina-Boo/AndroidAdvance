package com.example.androidadvance.diffutiltest

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidadvance.R

class DiffActivity : AppCompatActivity() {
    companion object {
        var innerClass: Any? = null
    }
    private var datas: ArrayList<TestBean>? = null
    private var rv: RecyclerView? = null
    private var adapter:DiffAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.diff_activity_layout)
        initData()
        rv = findViewById(R.id.rv_diff)
        rv!!.layoutManager = LinearLayoutManager(this)
        adapter = DiffAdapter(this,datas!!)
        rv!!.adapter = adapter
        val button = findViewById<Button>(R.id.btn_refresh)
        button.setOnClickListener {
            createInnerClass()
            onRefresh()
        }
    }

    private fun initData() {
        datas = ArrayList()
        datas!!.add(TestBean("john nash","Economist",R.drawable.john_nash))
        datas!!.add(TestBean("alicia","MIT",R.drawable.alicia_nash))
        datas!!.add(TestBean("beautiful mind","movie",R.drawable.a_beautiful_mind))
        datas!!.add(TestBean("jennifer connell","actress",R.drawable.jennifer_connelly))
        datas!!.add(TestBean("Russell Crowe", "actor", R.drawable.russell_crowe))
    }

    /**
     * 模拟刷新操作
     */
    private fun onRefresh() {
        try {
            val newDatas = ArrayList<TestBean>()
            for (bean in datas!!) {
                newDatas.add(bean.clone())
            }
            // 模拟新增数据
            newDatas.add(TestBean("Schizophrenia","illness",R.drawable.schizophrenia))
            newDatas[0].desc = "JOHN NASH"
            //模拟修改数据
            newDatas[0].picSrc = R.drawable.russell_crowe
            //模拟数据位移
            val testBean = newDatas[1]
            newDatas.remove(testBean)
            newDatas.add(testBean)

            //利用DiffUtil.calculateDiff()方法，传入一个规则DiffUtil.Callback对象，和是否检测移动item的 boolean变量，
            // 得到DiffUtil.DiffResult 的对象
            val diffResult = DiffUtil.calculateDiff(DiffCallBack(datas,newDatas), true)
            //利用DiffUtil.DiffResult对象的dispatchUpdatesTo（）方法，传入RecyclerView的Adapter
            diffResult.dispatchUpdatesTo(adapter!!)
            //别忘了将新数据给adapter
            datas = newDatas
            adapter!!.datas = datas as ArrayList<TestBean>
//            adapter!!.notifyDataSetChanged()
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
    }

    inner class InnerClass {

    }
    fun createInnerClass() {
        innerClass = InnerClass()
    }

}