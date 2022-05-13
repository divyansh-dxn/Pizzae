package com.dxn.pizzae.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dxn.pizzae.data.models.CartItem
import com.dxn.pizzae.data.models.fakeCartItem
import com.dxn.pizzae.ui.components.CheckoutListItem
import com.dxn.pizzae.ui.components.DescText
import com.dxn.pizzae.ui.components.MyButton
import com.dxn.pizzae.ui.components.TitleText
import com.dxn.pizzae.ui.theme.GrayBlue
import com.dxn.pizzae.ui.theme.PizzaeTheme

@Composable
fun CheckoutScreen(
    navController: NavController,
    pizzas: List<CartItem>,
    updateQuantity: (String, Int) -> Unit
) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                TitleText(text = "Shopping Cart", textColor = GrayBlue)
            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Rounded.Menu,
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
                items(pizzas) { item ->
                    CheckoutListItem(
                        item = item,
                        count = item.count,
                        onCountChange = { updateQuantity(item.id, it) })
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

@Preview
@Composable
fun CartPreview() {
    val context = LocalContext.current
    PizzaeTheme {
        CheckoutScreen(navController = rememberNavController(), pizzas = MutableList(3) {
            fakeCartItem
        }, updateQuantity = { id, qty ->
            Toast.makeText(context, "CLICKED", Toast.LENGTH_SHORT).show()
        }
        )
    }
}