package com.mhl.medit.recadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mhl.medit.R

class StateRecycler(val context: Context, val list : ArrayList<state>) : RecyclerView.Adapter<StateRecycler.MyVH>(){
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
        holder.image.setImageResource(list[position].image_state)
        holder.textTitle.text = (list[position].title)
        holder.textSubtitle.text = (list[position].text_state)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}