package com.example.gootaxtestproject.presentation.adapters

import android.graphics.Paint
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
import com.example.gootaxtestproject.data.PromotionalItems

class PromotionalItemsAdapter() : ListAdapter<PromotionalItems, PromotionalItemsAdapter.PromotionalItemsViewHolder>(PromotionalItemsDIffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  PromotionalItemsAdapter.PromotionalItemsViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_promotional_items,
            parent,
            false
        )
        return PromotionalItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PromotionalItemsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PromotionalItemsViewHolder(view: View) : ViewHolder(view) {
        private val tvSale: TextView = itemView.findViewById(R.id.tv_sale)
        private val ivImage: ImageView = itemView.findViewById(R.id.iv_image)
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvWeight: TextView = itemView.findViewById(R.id.tv_weight)
        private val tvOldPrice: TextView = itemView.findViewById(R.id.tv_old_price)
        private val tvPriceNow: TextView = itemView.findViewById(R.id.tv_price_now)

        fun bind(item: PromotionalItems) {
            tvSale.text = item.sale
            ivImage.setImageResource(item.image)
            tvName.text = item.name
            tvWeight.text = item.weight
            tvOldPrice.text = item.oldPrice
            tvOldPrice.paintFlags = tvOldPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            tvPriceNow.text = item.priceNow

            itemView.setOnClickListener {
                Log.d("item", item.name)
            }
        }
    }
}

object  PromotionalItemsDIffUtils: DiffUtil.ItemCallback<PromotionalItems>(){

    override fun areItemsTheSame(oldItem: PromotionalItems, newItem: PromotionalItems): Boolean {
        return oldItem::class == newItem::class
    }

    override fun areContentsTheSame(oldItem: PromotionalItems, newItem: PromotionalItems): Boolean {
        return oldItem == newItem
    }
}