package com.example.gootaxtestproject.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.gootaxtestproject.R
import com.example.gootaxtestproject.data.PromoItems

class PromoAdapter : ListAdapter<PromoItems, PromoAdapter.PromoViewHolder>(PromoDIffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  PromoAdapter.PromoViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_promo,
            parent,
            false
        )
        return PromoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PromoViewHolder(view: View) : ViewHolder(view) {
        private var ivImage: ImageView = itemView.findViewById(R.id.iv_image)
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)

        fun bind(item: PromoItems) {
            ivImage.setImageResource(item.image)
            tvName.text = item.name
            itemView.setOnClickListener {
                Log.d("item", item.name)
            }
        }
    }
}

object  PromoDIffUtils: DiffUtil.ItemCallback<PromoItems>(){

    override fun areItemsTheSame(oldItem: PromoItems, newItem: PromoItems): Boolean {
        return oldItem::class == newItem::class
    }

    override fun areContentsTheSame(oldItem: PromoItems, newItem: PromoItems): Boolean {
        return oldItem == newItem
    }
}