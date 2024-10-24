package com.example.gootaxtestproject.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.gootaxtestproject.R
import com.example.gootaxtestproject.data.Items

class ContainerAdapter :
    ListAdapter<Items, ContainerAdapter.ContainerViewHolder>(BASE_DIFF_CALLBACK2) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContainerViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_container,
                parent,
                false
            )

        return ContainerViewHolder(item)
    }

    override fun onBindViewHolder(holder: ContainerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ContainerViewHolder(private val view: View) : ViewHolder(view) {

        private val rvPromo: RecyclerView = view.findViewById(R.id.rv_promo)
        private val tvName: TextView = view.findViewById(R.id.block_name_tv)
        private val ivAll: ImageView = view.findViewById(R.id.show_all_iv)


        private val promoAdapter = PromoAdapter()
        private val promoBannerAdapter = PromoBannerAdapter()
        private val promotionsItemsAdapter = PromotionalItemsAdapter()
        private val categoriesAdapter = CategoriesAdapter()

        fun bind(item: Items) {

            tvName.isVisible = item is Items.CategoriesUiItems || item is Items.PromotionalItemsUiItems
            ivAll.isVisible = item is Items.PromotionalItemsUiItems


            when (item) {
                is Items.CategoriesUiItems -> {
                    rvPromo.layoutManager = GridLayoutManager(view.context, 3)
                    rvPromo.adapter = categoriesAdapter
                    categoriesAdapter.submitList(item.items)
                    tvName.text = "Категории"
                }

                is Items.PromoUiItems -> {
                    rvPromo.layoutManager =
                        LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
                    rvPromo.adapter = promoAdapter
                    promoAdapter.submitList(item.items)
                }

                is Items.PromoBannerUiIItems -> {
                    rvPromo.layoutManager =
                        LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
                    rvPromo.adapter = promoBannerAdapter
                    promoBannerAdapter.submitList(item.items)
                }

                is Items.PromotionalItemsUiItems -> {
                    rvPromo.layoutManager =
                        LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
                    rvPromo.adapter = promotionsItemsAdapter
                    promotionsItemsAdapter.submitList(item.items)
                    tvName.text = "Акции"
                }
            }
        }
    }
}

val BASE_DIFF_CALLBACK2 = object : DiffUtil.ItemCallback<Items>() {

    override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
        return oldItem::class == newItem::class
    }

    override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
        return oldItem == newItem
    }
}