package com.dxn.pizzae.ui.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dxn.pizzae.data.models.CartItem

class MainViewModel : ViewModel() {

    val cartItems = mutableStateOf(listOf<CartItem>())

    fun addToCart(cartItem: CartItem) {
        val newList = cartItems.value.toMutableList().apply { add(cartItem) }
        cartItems.value = newList
    }

    fun removeFromCart(cartItem: CartItem) {
        val newList = cartItems.value.toMutableList().apply { remove(cartItem) }
        cartItems.value = newList
    }

    fun updateQuantity(id: String, qty: Int) {
        val newList = cartItems.value.toMutableList().onEach {
            if (it.id == id) it.count = qty
        }
        cartItems.value = newList
    }

}