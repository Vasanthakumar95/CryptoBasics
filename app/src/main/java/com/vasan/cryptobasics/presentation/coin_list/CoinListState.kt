package com.vasan.cryptobasics.presentation.coin_list

import com.vasan.cryptobasics.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
