package com.dxn.pizzae.data.models

import android.content.Context
import com.dxn.pizzae.R

data class Pizza(
    val crusts: List<Crust>,
    val defaultCrust: Int,
    val description: String,
    val isVeg: Boolean,
    val name: String
)

fun getFakePizza(context: Context) = Pizza(
    crusts = listOf(fakeCrust1, fakeCrust2),
    defaultCrust = 1,
    description = context.getString(R.string.dummy_desc),
    name = "Non-Veg Pizza",
    isVeg = false
)