package com.dxn.pizzae

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.dxn.pizzae.data.models.CartItem
import com.dxn.pizzae.ui.theme.PizzaeTheme

class MainActivity : ComponentActivity() {

    private lateinit var favourites: MutableState<List<CartItem>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaeTheme(isVeg = false) {
                favourites = remember { mutableStateOf(listOf()) }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }

//    fun addItemToCart(cartItem: CartItem) {
//        val newList = favourites.value.toMutableList()
//        favourites.setValue()
//    }
}