package com.baharudin.foodapp.data.model

import androidx.annotation.DrawableRes
import com.baharudin.foodapp.R

data class Food(
    @DrawableRes val image : Int,
    val name : String,
    val type : String,
    val rating : Double,
    val price : Double,
    val description : String,
    val bundle : List<Int> = listOf()
)

val dummyFood = listOf(
    Food(
        image = R.drawable.bread,
        name = "Bakwan",
        type = "Goregan",
        rating = 4.0,
        price = 1.000,
        description = "Bakwan adalah makanan pembuka ketika sarapan para kuli"
    ),
    Food(
        image = R.drawable.bread,
        name = "Bakwan",
        type = "Goregan",
        rating = 4.0,
        price = 1.000,
        description = "Bakwan adalah makanan pembuka ketika sarapan para kuli"
    ),
    Food(
        image = R.drawable.carrot,
        name = "Bakwan",
        type = "Goregan",
        rating = 4.0,
        price = 1.000,
        description = "Bakwan adalah makanan pembuka ketika sarapan para kuli"
    ),
    Food(
        image = R.drawable.bread,
        name = "Bakwan",
        type = "Goregan",
        rating = 4.0,
        price = 1.000,
        description = "Bakwan adalah makanan pembuka ketika sarapan para kuli"
    ),
    Food(
        image = R.drawable.spinach,
        name = "Bakwan",
        type = "Goregan",
        rating = 4.0,
        price = 1.000,
        description = "Bakwan adalah makanan pembuka ketika sarapan para kuli"
    ),

)
