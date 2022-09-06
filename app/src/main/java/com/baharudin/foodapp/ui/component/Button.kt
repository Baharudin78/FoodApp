package com.baharudin.foodapp.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baharudin.foodapp.ui.theme.FoodAppTheme

@Composable
fun PrimaryButton(
    text : String,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(50.dp),
        contentPadding = PaddingValues(
            vertical = 12.dp
        ),
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    FoodAppTheme {
        PrimaryButton(
            text = "Mulai",
            onClick = { })
    }
}