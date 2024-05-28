package com.example.recipebook

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CategoriesDetailScreen(category: Category, navigateToRecipeScreen:(Category) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment= Alignment.CenterHorizontally
    ) {
        Text(text = category.strCategory, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier
                .wrapContentSize()
                .aspectRatio(1f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box (Modifier.fillMaxSize()){
            Text(
                text = category.strCategoryDescription,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.verticalScroll(rememberScrollState())
            )
        }
    }



}


