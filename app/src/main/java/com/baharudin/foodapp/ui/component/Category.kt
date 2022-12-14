package com.baharudin.foodapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baharudin.foodapp.data.model.Category
import com.baharudin.foodapp.data.model.dummyCaegories
import com.baharudin.foodapp.ui.theme.FoodAppTheme

@ExperimentalMaterialApi
@Composable
fun CategoryItem(
    category: Category,
    onCategoryClick : (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Chip(
        onClick = {
            onCategoryClick
        },
        shape = RoundedCornerShape(50.dp),
        modifier = modifier,
        colors = ChipDefaults.chipColors(
            backgroundColor = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.onBackground
        )
    ) {
        Image(
            painter = painterResource(id = category.icon),
            contentDescription = category.name,
            modifier = Modifier
                .clip(shape = CircleShape)
                .padding(vertical = 6.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = category.name,
            style = MaterialTheme.typography.subtitle2.copy(
                color = MaterialTheme.colors.onSurface
            ),
            modifier = Modifier.padding(end = 4.dp)
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun Categories(
    categories : List<Category>,
    onClickCategory : (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 24.dp),
        modifier = modifier
    ) {
        items(categories) {
            CategoryItem(
                category = it,
                onCategoryClick = onClickCategory
            )
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun previewCategory() {
    FoodAppTheme {
        CategoryItem(category = dummyCaegories[0], onCategoryClick = {} )
    }
}