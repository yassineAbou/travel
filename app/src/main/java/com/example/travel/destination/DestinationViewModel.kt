package com.example.travel.destination

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.travel.city.City

class DestinationViewModel : ViewModel() {

    private val _cityItems = MutableLiveData<List<City>>()

    val cityItems: LiveData<List<City>>
        get() = _cityItems

    fun displayDestinations(city: List<City>) {
        _cityItems.value = city
    }

    fun showAlert(context: Context) {
        val alertDialog = AlertDialog.Builder(context)

        alertDialog.apply {
            setMessage("Functionality not available \uD83D\uDCE1")
            setNegativeButton("CLOSE") { _, _ ->  }

        }.create().show()
    }
}