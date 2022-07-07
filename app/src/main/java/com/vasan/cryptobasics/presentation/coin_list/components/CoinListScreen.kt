package com.vasan.cryptobasics.presentation.coin_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vasan.cryptobasics.presentation.Screen
import com.vasan.cryptobasics.presentation.coin_list.CoinListViewModel
import com.vasan.cryptobasics.presentation.coin_list.CoinSummaryViewModel

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel(),
    coinSummaryViewModel: CoinSummaryViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    val summaryState = coinSummaryViewModel.state.value
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Spacer(modifier = Modifier.height(15.dp))
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
            LazyColumn(modifier = Modifier.fillMaxSize()){
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