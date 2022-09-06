package com.baharudin.foodapp.data.model

import androidx.annotation.DrawableRes
import com.baharudin.foodapp.R

data class Category(
    val name : String,
    @DrawableRes val icon : Int
)

val dummyCaegories = listOf(
    Category("Roti", R.drawable.bread),
    Category("Wortel", R.drawable.carrot),
    Category("Sayur", R.drawable.spinach),
)
