package com.baharudin.foodapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baharudin.foodapp.R
import com.baharudin.foodapp.data.model.Food
import com.baharudin.foodapp.data.model.dummyFood
import com.baharudin.foodapp.ui.theme.FoodAppTheme

@Composable
fun FoodItem(
    food: Food,
    onFoodItem : (Food) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .clickable(
                onClick = { onFoodItem(food) }
            )
            .fillMaxWidth()
            .padding(
                horizontal = 24.dp,
                vertical = 8.dp
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = food.image),
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier.clip(RoundedCornerShape(24.dp))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = food.name,
                    style = MaterialTheme.typography.subtitle2.copy(
                        color = MaterialTheme.colors.onSurface
                    ),
                )
                Text(
                    text = food.type,
                    style = MaterialTheme.typography.body2.copy(
                        color = MaterialTheme.colors.onBackground
                    )
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = food.rating.toString(),
                style = MaterialTheme.typography.subtitle2.copy(
                    color = MaterialTheme.colors.onSurface
                )
            )
            Image(
                painter = painterResource(id = R.drawable.star ),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier.width(24.dp)
            )
        }
    }
}

@Preview
@Composable
fun previewFoodItem() {
    FoodAppTheme {
        FoodItem(food = dummyFood[0], onFoodItem = {})
    }
}