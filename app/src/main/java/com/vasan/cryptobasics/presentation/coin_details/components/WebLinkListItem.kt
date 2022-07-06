package com.vasan.cryptobasics.presentation.coin_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.vasan.cryptobasics.presentation.ui.theme.ColorPrimary2

@Composable
fun WebLinkListItem(
    link: String,
    onItemClick: (String) -> Unit
){
    Row(
        modifier = Modifier
            .clickable { onItemClick(link) }
            .border(
                width = 1.dp,
                color = ColorPrimary2,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = link,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            color = ColorPrimary2
        )
    }

}