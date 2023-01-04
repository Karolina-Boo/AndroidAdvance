package com.example.androidadvance.viewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.androidadvance.R
import com.example.androidadvance.databinding.ActivityCustomGroupViewBinding
import com.example.androidadvance.databinding.ActivityCustomViewBinding
import com.example.androidadvance.databinding.CustomGroupViewBinding

class CustomGroupViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomGroupViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomGroupViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tbTitleBar.setTitle("自定义组合控件")

        binding.tbTitleBar.setLeftListener {
            Toast.makeText(this,"点击左键", Toast.LENGTH_SHORT).show()
        }

        binding.tbTitleBar.setRightListener {
            Toast.makeText(this,"点击右键",Toast.LENGTH_SHORT).show()
        }
    }
}