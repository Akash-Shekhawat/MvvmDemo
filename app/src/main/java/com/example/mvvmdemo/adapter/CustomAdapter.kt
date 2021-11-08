package com.example.mvvmdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.R
import com.example.mvvmdemo.model.DataItem

class CustomAdapter(private val mList: List<DataItem>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardviewdesign, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]


        holder.imageView.setImageResource(itemsViewModel.image)


        holder.textView.text = itemsViewModel.text

    }


    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)


    }
}