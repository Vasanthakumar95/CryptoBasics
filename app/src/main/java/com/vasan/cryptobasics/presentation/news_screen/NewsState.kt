package com.vasan.cryptobasics.presentation.news_screen

import com.vasan.cryptobasics.data.remote.dto.New

class NewsState (
    val isLoading: Boolean = false,
    val news: List<New> = emptyList(),
    val error: String = ""
)