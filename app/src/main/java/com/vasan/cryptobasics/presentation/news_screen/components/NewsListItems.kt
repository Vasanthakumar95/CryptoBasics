package com.vasan.cryptobasics.presentation.news_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.vasan.cryptobasics.data.remote.dto.New
import com.vasan.cryptobasics.presentation.ui.theme.ColorPrimary
import com.vasan.cryptobasics.presentation.ui.theme.DarkGray
import com.vasan.cryptobasics.presentation.ui.theme.MediumGray
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun NewsListItems(
    news: New,
    onItemClick: (New) -> Unit
){
    Card(
        modifier = Modifier
            .fillMaxWidth().padding(10.dp)
            .clickable { onItemClick(news) },

        elevation = 4.dp,
        backgroundColor = Color.Transparent,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(DarkGray, MediumGray),
                        start = Offset(0f, Float.POSITIVE_INFINITY),
                        end = Offset(Float.POSITIVE_INFINITY, 0f)
                    )
                ).padding(10.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(news.imgURL)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.align(Alignment.CenterHorizontally),

            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = news.title,
                style = MaterialTheme.typography.h6,
            )
            Row() {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(news.icon)
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(40.dp).padding(5.dp).clip(CircleShape)
                )
                Text(
                    text = "${news.source} - ${convertDate(news.feedDate)}",
                    color = ColorPrimary,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Text(
                text = news.description,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

fun convertDate(seconds: Long): String{
    val date = Date(seconds)
    val df = SimpleDateFormat("EEEE,MMMM d,yyyy h:mm,a", Locale.ENGLISH)
    df.timeZone = TimeZone.getTimeZone("UTC")
    return df.format(date).toString()
}