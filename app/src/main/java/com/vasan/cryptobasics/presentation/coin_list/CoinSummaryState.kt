package com.vasan.cryptobasics.presentation.coin_list

import com.vasan.cryptobasics.data.remote.dto.MainCoin

class CoinSummaryState (
    val isLoading: Boolean = false,
    val coinSummary: List<MainCoin> = emptyList(),
    val error: String = ""
)