package com.example.rtnotesapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_text_only.view.*

class ListAdapter(private val myDataset: Array<String>) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_text_only, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.text_only.text = myDataset[position]
    }


    override fun getItemCount() = myDataset.size

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}