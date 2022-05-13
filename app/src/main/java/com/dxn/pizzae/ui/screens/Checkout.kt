package com.dxn.pizzae.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dxn.pizzae.ui.components.CheckoutListItem
import com.dxn.pizzae.ui.components.DescText
import com.dxn.pizzae.ui.components.MyButton
import com.dxn.pizzae.ui.components.TitleText
import com.dxn.pizzae.ui.main.MainViewModel
import com.dxn.pizzae.ui.theme.GrayBlue
import com.dxn.pizzae.ui.theme.PizzaeTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun CheckoutScreen(
    navController: NavController,
    viewModel: MainViewModel
) {
    val pizzas = remember { viewModel.cartItems }
    var total by remember {viewModel.totalPrice}

    PizzaeTheme {
        val statusBarColor = MaterialTheme.colors.surface
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.apply {
                setSystemBarsColor(statusBarColor, darkIcons = true)
            }
        }
        Scaffold(topBar = {
            TopAppBar(
                title = {
                    TitleText(text = "Shopping Cart", textColor = GrayBlue)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "navigation Icon",
                            tint = GrayBlue
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.surface,
                elevation = 0.dp
            )
        }) {
            Column(Modifier.fillMaxSize()) {
                LazyColumn(
                    Modifier
                        .padding(8.dp)
                        .weight(1f)
                ) {
                    item {
                        DescText(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp),
                            text = "${pizzas.size} items in your cart",
                            textColor = GrayBlue
                        )
                    }
                    itemsIndexed(pizzas) { index, item ->
                        var count by remember { mutableStateOf(item.count) }
                        CheckoutListItem(
                            item = item,
                            count = count,
                            onIncrement = {
                                count++
                                viewModel.increaseQty(index)
                            },
                            onDecrement = {
                                count--
                                if(count==0) {
                                    viewModel.removeFromCart(item)
                                } else {
                                    viewModel.decreaseQty(index)
                                }
                            }
                           )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            TitleText(text = "Cart Total:", textColor = GrayBlue)
                            TitleText(text = "₹$total", textColor = GrayBlue)
                        }
                    }
                }
                MyButton(
                    modifier = Modifier.padding(16.dp),
                    backgroundColor = GrayBlue,
                    textColor = Color.White,
                    text = "Checkout",
                    leftIcon = Icons.Rounded.ArrowForward,
                    leftIconContentDescription = "Checkout"
                ) {

                }
            }
        }
    }


}