package com.example.travel.city

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.travel.databinding.CityItemBinding


class CityItemsAdapter (private val clickListener: CityItemListener) :
    ListAdapter<City, CityItemsAdapter.ViewHolder>(PlaceItemDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)!!
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: CityItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(
            item: City,
            clickListener: CityItemListener
        ) {
            binding.apply {
                cityItem = item
                clickListenerBind = clickListener
                executePendingBindings()

            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CityItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }




}

class PlaceItemDiffCallback : DiffUtil.ItemCallback<City>() {

    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem.id== newItem.id
    }

    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem == newItem
    }
}

class CityItemListener(val clickListener: (city: City) -> Unit) {
    fun onClick(city: City) = clickListener(city)
}






