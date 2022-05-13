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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
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
    PizzaeTheme {
        val statusBarColor = MaterialTheme.colors.surface
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.apply {
                setSystemBarsColor(statusBarColor,darkIcons = true)
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
                            text = "${5} items in your cart",
                            textColor = GrayBlue
                        )
                    }
                    itemsIndexed(pizzas) { index, item ->
                        var count by remember { mutableStateOf(item.count) }
                        CheckoutListItem(
                            item = item,
                            count = count,
                            onCountChange = { newCount ->
                                if (newCount == 0) {
                                    viewModel.removeFromCart(item)
                                } else {
                                    count = newCount
                                    viewModel.updateQuantity(index, count)
                                }
                            })
                        Spacer(modifier = Modifier.height(16.dp))
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