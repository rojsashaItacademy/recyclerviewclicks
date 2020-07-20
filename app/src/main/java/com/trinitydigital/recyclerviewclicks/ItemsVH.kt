package com.trinitydigital.recyclerviewclicks

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_lineawr.view.*

class ItemsVH(view: View) : RecyclerView.ViewHolder(view) {

    val imageURL: String? =
        "https://filedn.com/ltOdFv1aqz1YIFhf4gTY8D7/ingus-info/BLOGS/Photography-stocks3/stock-photography-slider.jpg"

    fun bind(
        item: ItemsData,
        listener: ItemListener,
        position: Int
    ) {

        itemView.title.text = item.title
        itemView.desc.text = item.desc

        Picasso.get().load(imageURL ?: "")
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(itemView.image)

        itemView.setOnClickListener {
            listener.itemClicks(item)
        }
    }
}
