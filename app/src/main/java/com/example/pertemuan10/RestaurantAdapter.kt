package com.example.pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pertemuan10.databinding.ItemRestaurantBinding

class RestaurantAdapter() :
    RecyclerView.Adapter<RestaurantAdapter.ItemRestaurantViewHolder>() {

    inner class ItemRestaurantViewHolder(private val
//                                       refer ke item_restaurant.xml
                                         binding: ItemRestaurantBinding):
            RecyclerView.ViewHolder(binding.root){

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRestaurantViewHolder {
        val binding = ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context),
        parent, false)
        return ItemRestaurantViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ItemRestaurantViewHolder, position: Int) {

    }
}