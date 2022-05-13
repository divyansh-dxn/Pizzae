package com.dxn.pizzae.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dxn.pizzae.data.models.getFakePizza
import com.dxn.pizzae.ui.screens.CheckoutScreen
import com.dxn.pizzae.ui.screens.PizzaDesc

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel by viewModels<MainViewModel>()
            val cartItems by remember { viewModel.cartItems }
            val navController = rememberNavController()

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                NavHost(navController = navController, startDestination = "description") {
                    composable("description") {
                        PizzaDesc(navController, pizza = getFakePizza(this@MainActivity)) { item ->
                            if (!cartItems.map { it.id }.contains(item.id))
                                viewModel.addToCart(item)
                        }
                    }
                    composable("cart") {
                        CheckoutScreen(
                            navController = navController,
                            pizzas = cartItems,
                            updateQuantity = { id, qty ->
                                viewModel.updateQuantity(id, qty)
                            }
                        )
                    }
                }
            }
        }
    }
}