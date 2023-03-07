package com.example.androidadvance.diffutiltest

class TestBean(val name: String, var desc: String, var picSrc: Int): Cloneable {

    public override fun clone(): TestBean {
        var bean: TestBean? = null
        try {
            bean = super.clone() as TestBean
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }
        return bean!!
    }
}