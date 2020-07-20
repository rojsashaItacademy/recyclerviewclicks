package com.trinitydigital.recyclerviewclicks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(private val listener: ItemListener) : RecyclerView.Adapter<ItemsVH>() {

    private var data = arrayListOf<ItemsData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lineawr, parent, false)
        return ItemsVH(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ItemsVH, position: Int) {
        holder.bind(data[position], listener, position)
    }

    fun update(data: ArrayList<ItemsData>) {
        this.data = data
        notifyDataSetChanged()
    }

    fun delete(pos: Int) {
        if (pos > -1 && data.size > pos) {
            data.removeAt(pos)
            notifyItemRemoved(pos)
            notifyItemRangeChanged(pos, data.size)
        }
    }

    fun add(item: ItemsData) {
        data.add(1, item)
        notifyItemInserted(1)
    }
}