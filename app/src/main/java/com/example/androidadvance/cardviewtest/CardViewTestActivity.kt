package com.example.androidadvance.cardviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.cardview.widget.CardView
import com.example.androidadvance.R

class CardViewTestActivity : AppCompatActivity() {
    private lateinit var mCardView: CardView
    private lateinit var sb1: SeekBar
    private lateinit var sb2: SeekBar
    private lateinit var sb3: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view_test)
        assignViews()
    }

    private fun assignViews() {
        mCardView = findViewById(R.id.cv_item)
        sb1 = findViewById(R.id.sb_1)
        sb2 = findViewById(R.id.sb_2)
        sb3 = findViewById(R.id.sb_3)
        sb1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, b: Boolean) {
                mCardView.radius = i.toFloat()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
        sb2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, b: Boolean) {
                mCardView.cardElevation = i.toFloat()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        sb3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, b: Boolean) {
                mCardView.setContentPadding(i,i,i,i)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }
}