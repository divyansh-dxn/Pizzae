package com.dxn.pizzae.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dxn.pizzae.R
import com.dxn.pizzae.data.models.CartItem
import com.dxn.pizzae.ui.theme.GrayBlue
import com.dxn.pizzae.ui.theme.PizzaeTheme

@Composable
fun CheckoutListItem(
    item: CartItem,
    height: Dp = 84.dp,
    count: Int,
    onCountChange: (Int) -> Unit
) {
    PizzaeTheme(isVeg = false) {
        Row(Modifier.height(height), verticalAlignment = Alignment.CenterVertically) {
            Box(
                Modifier
                    .size(height)
                    .clip(RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(height),
                    painter = painterResource(
                        id = if (item.isVeg) R.drawable.bg_veg else R.drawable.bg_non_veg,
                    ),
                    contentDescription = "",
                    contentScale = ContentScale.Fit
                )
                Image(
                    modifier = Modifier
                        .size(height.times(0.9f))
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(4.dp),
                    painter = painterResource(R.drawable.pizza),
                    contentDescription = "",
                    contentScale = ContentScale.Fit
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = item.name,
                        color = GrayBlue,
                        style = MaterialTheme.typography.h6.copy(
                            fontWeight = FontWeight(500)
                        )
                    )
                    Text(
                        text = item.desc,
                        style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight(300))
                    )
                }
                Text(
                    text = "₹${item.priceEach}",
                    style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight(500)),
                    color = MaterialTheme.colors.primary
                )
            }
            Counter(
                count = count,
                onCountChange = onCountChange,
                tint = MaterialTheme.colors.primary
            )
        }
    }
}

@Preview
@Composable
fun Previie() {
    var count by remember { mutableStateOf(0) }
    val item = CartItem(
        name = "Non-Veg Pizza",
        priceEach = 290.4f,
        desc = "Hand-Tossed | L",
        isVeg = false,
        count = 1
    )
    CheckoutListItem(item = item, count = count, onCountChange = { count = it })
}