package com.example.recipebook

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells.*
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter


@Composable
fun RecipeScreen( modifier: Modifier = Modifier,
                  viewState: MainViewModel.RecipeState,
                  navigateToDetailScreen:(Category) -> Unit)
{
    Box (
        modifier = Modifier.fillMaxSize()
    ){
        when{
            viewState.loading -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }
            viewState.error != null -> {
                Text(text = "Error Occured ${viewState.error}")
            }
            else ->{
                //Display Categories
                CategoryScreen(categories = viewState.list, navigateToDetailScreen)
            }
        }
    }
}

@Composable
fun CategoryScreen(
    categories: List<Category>,
    navigateToDetailScreen:(Category) -> Unit
    ) {
    LazyVerticalGrid(
        Fixed(2),
        Modifier.fillMaxSize()
        ){
        items(categories) {
            categoryItem ->
            CategoryItem(category = categoryItem, navigateToDetailScreen)
        }
    }
}


// Navigate By CLicking The Item
@Composable
fun CategoryItem(category : Category, navigateToDetailScreen:(Category) -> Unit) {
    Column(
        modifier = Modifier.padding(8.dp).fillMaxSize().clickable { navigateToDetailScreen(category) },
        horizontalAlignment = Alignment.CenterHorizontally,
    ){

        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )

        Text(
            text = category.strCategory,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 8.dp)
        )

    }
}