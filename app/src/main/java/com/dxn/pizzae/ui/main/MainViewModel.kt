package com.dxn.pizzae.ui.main

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.dxn.pizzae.data.models.CartItem
import kotlin.random.Random

class MainViewModel : ViewModel() {
    val cartItems = mutableStateListOf<CartItem>()

    fun addToCart(cartItem: CartItem) = cartItems.add(cartItem)
    fun removeFromCart(cartItem: CartItem) = cartItems.remove(cartItem)

    fun updateQuantity(index: Int, qty: Int) {
        val pre = cartItems[index]
        val new = CartItem(
            name = "Non-Veg Pizza",
            priceEach = 290.4f,
            desc = "Hand-Tossed | L",
            isVeg = false,
            count = qty
        )
        Log.d("TAG_TAG", "updateQuantity: $pre $new")
        cartItems[index] = new
    }
}