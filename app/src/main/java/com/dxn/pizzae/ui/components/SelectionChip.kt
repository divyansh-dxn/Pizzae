package com.dxn.pizzae.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dxn.pizzae.ui.theme.PizzaeTheme

@Composable
fun SelectionChipRow(
    modifier: Modifier,
    options: List<Any>,
    selected: Int,
    onSelect: (Int) -> Unit,
) {
    LazyRow(modifier.fillMaxWidth()) {
        itemsIndexed(options) { index, option ->
            val isSelected = (index == selected)
            Row(
                Modifier
                    .padding(horizontal = 4.dp)
                    .clip(CircleShape)
                    .border(
                        (2).dp,
                        if (!isSelected) Color.Transparent else MaterialTheme.colors.primary,
                        CircleShape
                    )
                    .background(
                        MaterialTheme.colors.primaryVariant.copy(alpha = 0.4f),
                        CircleShape
                    )
                    .clickable { onSelect(index) }
                    .padding(8.dp)
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = option.toString(),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.primary,
                    maxLines = 2
                )
            }
        }
    }
}

@Preview
@Composable
fun Preve() {
    PizzaeTheme(isVeg = false) {
        val items by remember {
            mutableStateOf(
                listOf(
                    "First\n444",
                    "Second\n444",
                    "Third",
                    "First",
                    "Second",
                    "Third",
                    "First",
                    "Second",
                    "Third",
                    "First",
                )
            )
        }
        var selected by remember { mutableStateOf(0) }
        SelectionChipRow(
            modifier = Modifier,
            options = items,
            selected = selected
        ) {
            selected = it
        }

    }
}
