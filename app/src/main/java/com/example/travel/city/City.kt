package com.example.travel.city


import androidx.annotation.DrawableRes
import java.util.*

data class City(
    val name: String,
    @DrawableRes val drawable: Int,
    val id: UUID = UUID.randomUUID()
)
