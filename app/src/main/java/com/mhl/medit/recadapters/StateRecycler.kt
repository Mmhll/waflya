package com.mhl.medit.recadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mhl.medit.R
import com.mhl.medit.retrofit.data_quotes
import com.mhl.medit.retrofit.quotes

class StateRecycler(val context: Context, val quotes: quotes) : RecyclerView.Adapter<StateRecycler.MyVH>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateRecycler.MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.state_adapter, parent, false)
        return MyVH(root)
    }
    class MyVH(itemView : View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.imageView4)
        val textTitle : TextView = itemView.findViewById(R.id.state_title)
        val textSubtitle : TextView = itemView.findViewById(R.id.state_subtitle)
    }
    override fun onBindViewHolder(holder: StateRecycler.MyVH, position: Int) {
        Glide.with(context).load(quotes.arrayQuotes[position].image).into(holder.image)
        holder.textTitle.setText(quotes.arrayQuotes[position].title)
        holder.textSubtitle.setText(quotes.arrayQuotes[position].description)
    }

    override fun getItemCount(): Int {
        return quotes.arrayQuotes.size
    }
}