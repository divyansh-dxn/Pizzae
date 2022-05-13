package com.dxn.pizzae.data.models

data class CartItem(
    val name: String,
    var count: Int,
    val priceEach: Float,
    val desc: String,
    val isVeg:Boolean
)

val fakeCartItem =  CartItem(
    name = "Non-Veg Pizza",
    priceEach = 290.4f,
    desc = "Hand-Tossed | L",
    isVeg = false,
    count = 1
)