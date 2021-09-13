package com.example.sharedanimationtransation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(private val onItemClickListener: (imageView: ImageView, position: Int) -> Unit) :
    RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imageView.transitionName = "image $position"
        holder.itemView.setOnClickListener {
            onItemClickListener(holder.imageView, position)
        }
    }

    override fun getItemCount(): Int {
        return 15
    }
}