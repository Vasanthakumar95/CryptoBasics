package com.vasan.cryptobasics.data.remote

import com.vasan.cryptobasics.data.remote.dto.CoinDTO
import com.vasan.cryptobasics.data.remote.dto.CoinDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDTO>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailsDTO

}