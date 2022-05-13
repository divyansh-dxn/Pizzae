package com.dxn.pizzae.ui.main

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dxn.pizzae.data.models.CartItem

class MainViewModel : ViewModel() {
    val cartItems = mutableStateListOf<CartItem>()
    val totalPrice = mutableStateOf(0f)

    fun addToCart(cartItem: CartItem) {
        cartItems.add(cartItem)
        totalPrice.value += cartItem.priceEach
    }

    fun removeFromCart(cartItem: CartItem) {
        totalPrice.value -= cartItem.priceEach
        cartItems.remove(cartItem)
    }

    fun increaseQty(index: Int) {
        val temp = cartItems[index]
        totalPrice.value += temp.priceEach
        val new = temp.copy(count = temp.count + 1)
        cartItems[index] = new
    }

    fun decreaseQty(index: Int) {
        val temp = cartItems[index]
        totalPrice.value -= temp.priceEach
        val new = temp.copy(count = temp.count - 1)
        cartItems[index] = new
    }
}