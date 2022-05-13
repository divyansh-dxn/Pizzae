package com.dxn.pizzae.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.dxn.pizzae.R
import com.dxn.pizzae.data.models.CartItem
import com.dxn.pizzae.data.models.Pizza
import com.dxn.pizzae.ui.components.*
import com.dxn.pizzae.ui.theme.PizzaeTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun PizzaDesc(
    navController: NavController,
    pizza: Pizza,
    addToCart: (CartItem) -> Unit,
) {
    var crust by remember { mutableStateOf(0) }
    var size by remember { mutableStateOf(0) }

    val statusBarColor = MaterialTheme.colors.primaryVariant
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(statusBarColor)
    }

    PizzaeTheme(isVeg = pizza.isVeg) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                        .fillMaxWidth()
                        .height(256.dp)
                ) {
                    BackButton(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.TopStart),
                        onClick = { }
                    )
                    Image(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .offset(x = 48.dp, y = (-24).dp)
                            .border(32.dp, MaterialTheme.colors.secondary, CircleShape)
                            .clip(CircleShape)
                            .size(256.dp)
                            .padding(16.dp),
                        painter = rememberAsyncImagePainter(model = R.drawable.pizza),
                        contentDescription = "Decoration around pizza image "
                    )
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .align(Alignment.BottomStart),
                        verticalAlignment = Alignment.Top
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_veg_sym),
                            contentDescription = "Veg or Non-veg Symbol",
                            tint = MaterialTheme.colors.primary,
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .size(24.dp)

                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(Modifier.weight(1f)) {
                            TitleText(
                                modifier = Modifier
                                    .padding(0.dp),
                                text = pizza.name,
                                textColor = MaterialTheme.colors.primary
                            )
                            DescText(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .padding(bottom = 0.dp),
                                text = pizza.name,
                                textColor = MaterialTheme.colors.primary
                            )
                        }
                    }

                }
            }
            item {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .background(MaterialTheme.colors.primaryVariant)
                )
            }
            item {
                Column(
                    modifier = Modifier
                        .offset(y = (-64).dp)
                        .clip(RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp))
                        .background(Color.White)
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 32.dp, end = 16.dp)
                ) {

                    TitleText(text = "Particulars", textColor = MaterialTheme.colors.primary)
                    DescText(text = pizza.description, textColor = MaterialTheme.colors.primary)
                    Spacer(modifier = Modifier.height(8.dp))

                    RatingBar(rating = 4, onRatingChange = {})
                    Spacer(modifier = Modifier.height(16.dp))

                    TitleText(text = "Crust", textColor = MaterialTheme.colors.primary)
                    SelectionChipRow(
                        modifier = Modifier.fillMaxWidth(),
                        options = pizza.crusts.map { it.name },
                        selected = crust,
                        onSelect = {
                            crust = it
                            size = 0
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    TitleText(text = "Size", textColor = MaterialTheme.colors.primary)
                    SelectionChipRow(
                        modifier = Modifier.fillMaxWidth(),
                        options = pizza.crusts[crust].sizes.map { "${it.name}\n₹${it.price}" },
                        selected = size,
                        onSelect = { size = it }
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Row {
                        MyButton(
                            modifier = Modifier.weight(1f),
                            backgroundColor = MaterialTheme.colors.primary,
                            textColor = MaterialTheme.colors.onPrimary,
                            text = "Add to Cart",
                            leftIcon = Icons.Rounded.ArrowForward,
                            leftIconContentDescription = "Add to cart"
                        ) {
                            val selectedCrust = pizza.crusts[crust]
                            val selectedSize = selectedCrust.sizes[size]
                            val cartItem = CartItem(
                                name = pizza.name,
                                desc = "${selectedCrust.name} | ${selectedSize.name}",
                                priceEach = selectedSize.price,
                                count = 1,
                                isVeg = pizza.isVeg
                            )
                            addToCart(cartItem)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        MyButton(
                            modifier = Modifier.weight(1f),
                            backgroundColor = MaterialTheme.colors.primary,
                            textColor = MaterialTheme.colors.onPrimary,
                            text = "Go to Cart",
                            leftIcon = Icons.Rounded.ArrowForward,
                            leftIconContentDescription = "Add to cart",
                        ) {
                            navController.navigate("cart")
                        }
                    }
                }
            }
        }
    }
}