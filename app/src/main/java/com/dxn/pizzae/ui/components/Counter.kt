package com.dxn.pizzae.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Counter(
    count: Int,
    minCount: Int = 0,
    maxCount: Int = Int.MAX_VALUE,
    tint: Color = Color.Black,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = { if (count < maxCount) onIncrement() }) {
            Text(text = "+", style = MaterialTheme.typography.h6, color = tint)
        }
        Text(text = "$count", style = MaterialTheme.typography.h5, color = tint)
        IconButton(onClick = { if (count > minCount) onDecrement() }) {
            Text(text = "-", style = MaterialTheme.typography.h6, color = tint)
        }
    }
}