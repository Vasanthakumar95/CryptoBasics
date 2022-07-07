package com.vasan.cryptobasics.data.remote

import com.vasan.cryptobasics.data.remote.dto.CoinSummaryDTO
import com.vasan.cryptobasics.data.remote.dto.NewsDTO
import retrofit2.http.GET
import retrofit2.http.Query


interface CoinStatsApi {

    @GET("/public/v1/news/trending")
    suspend fun getNews(@Query("skip") skip: Int, @Query("limit") limit: Int): NewsDTO

    @GET("/public/v1/coins")
    suspend fun getCoinSummary(@Query("skip") skip: Int, @Query("limit") limit: Int, @Query("currency") currency: String): CoinSummaryDTO
}