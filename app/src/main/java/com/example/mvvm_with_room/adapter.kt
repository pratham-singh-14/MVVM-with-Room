package com.example.mvvm_with_room

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class adapter(private val mList: List<Quote>) : RecyclerView.Adapter<adapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        holder.tvid.text = ItemsViewModel.id.toString()
        holder.tvtext.text = ItemsViewModel.text.toString()
        holder.tvauthor.text = ItemsViewModel.author.toString()

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvid: TextView = itemView.findViewById(R.id.txtv)
        val tvtext: TextView = itemView.findViewById(R.id.txt)
        val tvauthor: TextView = itemView.findViewById(R.id.txauthor)
    }
}
