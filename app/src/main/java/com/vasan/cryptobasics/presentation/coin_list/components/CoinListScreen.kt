package com.vasan.cryptobasics.presentation.coin_list.components

import android.os.Build
import android.provider.Settings
import android.widget.Space
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vasan.cryptobasics.presentation.Screen
import com.vasan.cryptobasics.presentation.coin_list.CoinListViewModel
import com.vasan.cryptobasics.presentation.coin_list.CoinSummaryViewModel
import com.vasan.cryptobasics.presentation.ui.theme.ColorPrimary
import com.vasan.cryptobasics.presentation.ui.theme.ColorPrimary2
import com.vasan.cryptobasics.presentation.ui.theme.DarkGray
import com.vasan.cryptobasics.R
import com.vasan.cryptobasics.presentation.ui.theme.MediumGray

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel(),
    coinSummaryViewModel: CoinSummaryViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    val summaryState = coinSummaryViewModel.state.value

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {

//        TopAppBar(
//            modifier = Modifier.background(
//                Brush.linearGradient(
//                    colors = listOf(ColorPrimary2, ColorPrimary),
//                    start = Offset(0f, Float.POSITIVE_INFINITY),
//                    end = Offset(Float.POSITIVE_INFINITY, 0f)
//                )
//            ),
//            title = { Text("Welcome") },
//            backgroundColor = Color.Transparent,
//            elevation = 0.dp
//        )

        Text(
            text = "Welcome to CryptoBasics",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(top = 10.dp, start = 10.dp)
        )

        Text(
            text = "App to learn the Basics of Crypto",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(bottom = 5.dp, start = 10.dp)
        )
        Card(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            elevation = 4.dp,
            backgroundColor = Color.Transparent,
            shape = RoundedCornerShape(12.dp)
        ){
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(DarkGray, MediumGray),
                        start = Offset(0f, Float.POSITIVE_INFINITY),
                        end = Offset(Float.POSITIVE_INFINITY, 0f)
                    ), RoundedCornerShape(12.dp)
                ).padding(10.dp)
            ) {
                SliderView()
            }
        }

        Text(
            text = "TOP 20 COINS",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(10.dp)
        )

        Box(modifier = Modifier.fillMaxWidth()){
            LazyRow(modifier = Modifier.fillMaxWidth()){
                items(summaryState.coinSummary){ summary ->
                    CoinSummaryListItem(
                        mainCoin = summary
                    )
                }
            }
            if (summaryState.error.isNotBlank()){
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (summaryState.isLoading){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        Text(
            text = "Browse More Coins Below",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(10.dp)
        )

        Box(modifier = Modifier.fillMaxWidth()){
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .height(512.dp)){
                items(state.coins){ coin ->
                    CoinListItem(
                        coin = coin,
                        onItemClick = {
                            navController.navigate(Screen.CoinDetailsScreen.route + "/${coin.id}")
                        }
                    )
                }
            }
            if (state.error.isNotBlank()){
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}