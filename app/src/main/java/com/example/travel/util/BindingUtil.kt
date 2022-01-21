package com.example.travel.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.travel.city.City
import com.example.travel.city.CityItemsAdapter

@BindingAdapter("destination_listData")
fun bindDailyRecyclerView(recyclerView: RecyclerView, cities: List<City>?) {
    val adapter = recyclerView.adapter as CityItemsAdapter
    adapter.submitList(cities)
}

@BindingAdapter("city_img")
fun ImageView.setDailyWeatherImage(item: City) {
    item?.let {
        this.setImageResource(item.drawable)
    }

}

@BindingAdapter("city_name")
fun TextView.setDailyDateFormatted(item: City) {
    item?.let {
        text = item.name
    }
}