package com.dxn.pizzae.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.dxn.pizzae.R
import com.dxn.pizzae.ui.theme.PizzaeTheme

@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
) {
    Text(
        modifier = modifier,
        text = text,
        color = textColor,
        style = MaterialTheme.typography.h5.copy(
            fontWeight = FontWeight(400)
        )
    )
}

@Composable
fun DescText(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color
) {
    Text(
        modifier = modifier,
        text = text,
        color = textColor,
        style = MaterialTheme.typography.body1
    )
}

@Composable
@Preview
fun Prevee() {
    PizzaeTheme {
        Column() {
            TitleText(
                text = "Hello android",
                textColor = MaterialTheme.colors.primary
            )
            DescText(
                text = stringResource(id = R.string.dummy_desc) ,
                textColor = MaterialTheme.colors.primary
            )
        }

    }
}