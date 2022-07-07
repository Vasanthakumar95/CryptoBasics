package com.vasan.cryptobasics.domain.repository

import com.vasan.cryptobasics.data.remote.dto.CoinSummaryDTO
import com.vasan.cryptobasics.data.remote.dto.NewsDTO

interface NewsRepository {
    suspend fun getNews(): NewsDTO
    suspend fun getCoinSummary(): CoinSummaryDTO
}