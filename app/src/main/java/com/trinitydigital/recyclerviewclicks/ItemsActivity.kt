package com.trinitydigital.recyclerviewclicks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        val tvTitle = findViewById<TextView>(R.id.title)
        val item = intent.getParcelableExtra<ItemsData>("data")

        tvTitle.text = item?.title

    }
}