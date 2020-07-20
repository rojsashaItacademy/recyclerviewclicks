package com.trinitydigital.recyclerviewclicks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ItemListener {

    private var recyclerView: RecyclerView? = null
    private var etDelete: EditText? = null
    private var btnDelete: Button? = null
    val adapter = ItemsAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        setupRecyclerView()
        setupListeners()
    }

    private fun setupViews() {
        recyclerView = findViewById(R.id.recycler)
        etDelete = findViewById(R.id.etDelete)
        btnDelete = findViewById(R.id.btnDelete)
    }

    private fun setupRecyclerView() {
        recyclerView?.adapter = adapter
        adapter.update(getData())
    }

    private fun setupListeners() {
        btnDelete?.setOnClickListener {
            if (!etDelete?.text.isNullOrEmpty()) {
                adapter.delete(etDelete?.text.toString().toInt())
            } else {
                adapter.add(ItemsData("new 1 ", "newwwwww222222"))
            }
        }
    }

    private fun getData(): ArrayList<ItemsData> {
        val list = arrayListOf<ItemsData>()

        for (i in 1..50) {
            list.add(ItemsData("title $i", "decs $i"))
        }

        return list
    }

    override fun itemClicks(item: ItemsData) {
        val intent = Intent(this, ItemsActivity::class.java)
        intent.putExtra("data", item)
        startActivity(intent)
    }
}