package com.baharudin.foodapp.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    query : String,
    onQueryChange : (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = query ,
        onValueChange = onQueryChange,
        maxLines = 1,
        shape = RoundedCornerShape(50.dp),
        textStyle = MaterialTheme.typography.body1,

    )
}