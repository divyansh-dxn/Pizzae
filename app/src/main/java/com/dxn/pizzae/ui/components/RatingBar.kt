package com.dxn.pizzae.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dxn.pizzae.ui.theme.PizzaeTheme

@Composable
fun RatingBar(
    rating: Int,
    onRatingChange: (Int) -> Unit,
) {
    LazyRow(Modifier.padding(2.dp)) {
        items(5) { index ->
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable {
                        onRatingChange(index + 1)
                    }
                    ,
                imageVector = Icons.Rounded.Star,
                contentDescription = "Rating star",
                tint = MaterialTheme.colors.primary.copy(
                    alpha = if (index + 1 <= rating) 1f else 0.3f
                )
            )
        }
    }
}

@Preview
@Composable
fun Previ() {
    PizzaeTheme {
        var rating by remember { mutableStateOf(0) }
        RatingBar(rating = rating, onRatingChange = { rating = it })
    }
}