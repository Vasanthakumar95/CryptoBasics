package com.vasan.cryptobasics.presentation.news_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.vasan.cryptobasics.data.remote.dto.New

@Composable
fun NewsListItems(
    news: New,
    onItemClick: (New) -> Unit
){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(news) }
            .padding(10.dp)
    ) {
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(news.imgURL)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = news.title,
                style = MaterialTheme.typography.h4
            )
            Text(
                text = news.description,
                style = MaterialTheme.typography.body2
            )
        }
    }
}
