package com.example.gootaxtestproject.presentation.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.gootaxtestproject.R
import com.example.gootaxtestproject.data.CategoriesItems
import com.example.gootaxtestproject.data.PromoItems

class CategoriesAdapter() : ListAdapter<CategoriesItems, CategoriesAdapter.CategoriesViewHolder>(CategoriesDIffUtils) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  CategoriesAdapter.CategoriesViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_categories,
            parent,
            false
        )
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CategoriesViewHolder(view: View) : ViewHolder(view) {
        private var ivImage: ImageView = itemView.findViewById(R.id.iv_image)
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val cvCategories: CardView = itemView.findViewById(R.id.cv_categories)


        fun bind(item: CategoriesItems) {
            ivImage.setImageResource(item.image)
            tvName.text = item.name
            cvCategories.setCardBackgroundColor(Color.parseColor(item.background))
            itemView.setOnClickListener {
                Log.d("item", item.name)
            }
        }

    }
}

object CategoriesDIffUtils: DiffUtil.ItemCallback<CategoriesItems>(){

    override fun areItemsTheSame(oldItem: CategoriesItems, newItem: CategoriesItems): Boolean {
        return oldItem::class == newItem::class
    }

    override fun areContentsTheSame(oldItem: CategoriesItems, newItem: CategoriesItems): Boolean {
        return oldItem == newItem
    }
}