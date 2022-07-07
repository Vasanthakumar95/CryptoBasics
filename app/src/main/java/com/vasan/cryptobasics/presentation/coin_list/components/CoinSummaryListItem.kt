package com.vasan.cryptobasics.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.vasan.cryptobasics.data.remote.dto.MainCoin
import com.vasan.cryptobasics.presentation.ui.theme.ColorPrimary
import com.vasan.cryptobasics.presentation.ui.theme.ColorPrimary2
import com.vasan.cryptobasics.presentation.ui.theme.DarkGray
import kotlin.math.roundToInt

@Composable
fun CoinSummaryListItem(
    mainCoin: MainCoin
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(
            brush = Brush.linearGradient(
                colors = listOf(ColorPrimary2, ColorPrimary),
                start = Offset(0f, Float.POSITIVE_INFINITY),
                end = Offset(Float.POSITIVE_INFINITY, 0f)
            ), RoundedCornerShape(20)
        )
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(mainCoin.icon)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = (mainCoin.name).uppercase(),
                    style = MaterialTheme.typography.h6,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color = DarkGray
                )
                Text(
                    text = "Price RM${(mainCoin.price * 4.5).roundToInt()}",
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color = DarkGray,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Total Supply: ${(mainCoin.totalSupply).roundToInt()}",
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color = DarkGray
                )
                Text(
                    text = "Current Supply: ${(mainCoin.availableSupply).roundToInt()}",
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color = DarkGray
                )
            }
        }
    }
}