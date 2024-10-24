package com.example.gootaxtestproject.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.gootaxtestproject.R
import com.example.gootaxtestproject.data.PromoBannerItems

class PromoBannerAdapter() : ListAdapter<PromoBannerItems, PromoBannerAdapter.PromoBannerViewHolder>(PromoBannerDIffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  PromoBannerAdapter.PromoBannerViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_promo_banner,
            parent,
            false
        )
        return PromoBannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PromoBannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PromoBannerViewHolder(view: View) : ViewHolder(view) {
        private var ivBannerColor: ImageView = itemView.findViewById(R.id.iv_background)

        fun bind(item: PromoBannerItems) {
            ivBannerColor.setBackgroundResource(item.bannerColor)
            itemView.setOnClickListener {
                Log.d("item", "${item.bannerColor}")
            }
        }
    }
}

object  PromoBannerDIffUtils: DiffUtil.ItemCallback<PromoBannerItems>(){

    override fun areItemsTheSame(oldItem: PromoBannerItems, newItem: PromoBannerItems): Boolean {
        return oldItem::class == newItem::class
    }

    override fun areContentsTheSame(oldItem: PromoBannerItems, newItem: PromoBannerItems): Boolean {
        return oldItem == newItem
    }
}