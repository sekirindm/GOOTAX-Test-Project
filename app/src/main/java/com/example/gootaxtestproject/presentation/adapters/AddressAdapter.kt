package com.example.gootaxtestproject.presentation.adapters

import android.location.Address
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.gootaxtestproject.R
import com.example.gootaxtestproject.data.ItemList
import com.example.gootaxtestproject.data.network.model.Suggestion

class AddressAdapter(private val onClick: (String) -> Unit) :
    ListAdapter<ItemList, ViewHolder>(AddressDIffUtils) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_address, parent, false
        )
        return AddressViewHolder(view)
    }
    override fun getItemViewType(position: Int): Int {
        return when {
            getItem(position) is ItemList.AddressItemsList -> 0
            else -> {
                1
            }
        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is AddressViewHolder -> {
                val item = getItem(position) as ItemList.AddressItemsList
                val products = item.address
                holder.bind(products)
            }
        }
    }

    inner class AddressViewHolder(view: View) : ViewHolder(view) {
        private val tvAddress: TextView = view.findViewById(R.id.tv_address)
        private val tvFullAddress: TextView = view.findViewById(R.id.tv_full_address)


        fun bind(address: Suggestion) {
            val last = address.value.split(", ").takeLast(2).joinToString()
            tvFullAddress.text = address.value.replace(last, "")
            tvAddress.text = last

            itemView.setOnClickListener {
                onClick(last)
            }

        }
    }
}

object  AddressDIffUtils: DiffUtil.ItemCallback<ItemList>(){

    override fun areItemsTheSame(oldItem: ItemList, newItem: ItemList): Boolean {
        return oldItem::class == newItem::class
    }

    override fun areContentsTheSame(oldItem: ItemList, newItem: ItemList): Boolean {
        return oldItem == newItem
    }
}