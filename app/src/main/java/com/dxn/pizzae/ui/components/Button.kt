package com.dxn.pizzae.ui.components

import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dxn.pizzae.ui.theme.PizzaeTheme

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    textColor: Color,
    text: String,
    leftIcon: ImageVector,
    leftIconContentDescription: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = SpaceBetween
        ) {
            Text(text = text, color = textColor)
            Icon(imageVector = leftIcon, contentDescription = leftIconContentDescription)
        }
    }
}

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    color: Color = MaterialTheme.colors.primary
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "Back button",
            tint = color
        )
    }
}

@Preview
@Composable
fun Prev() {
    PizzaeTheme {
        MyButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            backgroundColor = MaterialTheme.colors.primary,
            textColor = MaterialTheme.colors.onPrimary,
            text = "Click Me",
            leftIcon = Icons.Filled.ArrowForward,
            leftIconContentDescription = "Next button"
        ) {

        }
    }
}