package com.vasan.cryptobasics.domain.repository

import com.vasan.cryptobasics.data.remote.CoinStatsApi
import com.vasan.cryptobasics.data.remote.dto.CoinSummaryDTO
import com.vasan.cryptobasics.data.remote.dto.NewsDTO
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: CoinStatsApi
) : NewsRepository {

    override suspend fun getNews(): NewsDTO {
        return api.getNews(0,20)
    }

    override suspend fun getCoinSummary(): CoinSummaryDTO {
        return api.getCoinSummary(0,20,"EUR")
    }
}