package com.example.giphy.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.giphy.R
import com.example.giphy.models.Data
import java.util.ArrayList

class GifsAdapter(val context: Context, private val gifsList: ArrayList<Data>) :
    RecyclerView.Adapter<GifsAdapter.GifsHolder>() {

    class GifsHolder(item: View) : RecyclerView.ViewHolder(item) {
        val gifImage: ImageView = item.findViewById(R.id.gifImView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gif_item, parent, false)
        return GifsHolder(view)
    }

    override fun onBindViewHolder(holder: GifsHolder, position: Int) {
        Glide.with(holder.itemView).asGif().load(gifsList[position].images.original.url)
            .into(holder.gifImage)
    }

    override fun getItemCount(): Int {
        return gifsList.size
    }
}