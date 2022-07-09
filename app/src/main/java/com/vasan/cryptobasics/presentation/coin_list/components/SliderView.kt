package com.vasan.cryptobasics.presentation.coin_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.vasan.cryptobasics.R

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SliderView() {

    val  imgs = listOf(R.drawable.carausel_2, R.drawable.carausel_3, R.drawable.carausel_4, R.drawable.carausel_5,R.drawable.carausel_6)
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = 5,
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth().aspectRatio(1f),
    ) { page ->
        Image(
            painterResource(imgs[page]),
            contentScale = ContentScale.Fit,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
    }

}
