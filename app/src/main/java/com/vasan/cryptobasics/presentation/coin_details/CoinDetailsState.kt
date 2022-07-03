package com.vasan.cryptobasics.presentation.coin_details

import com.vasan.cryptobasics.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = ""
)
