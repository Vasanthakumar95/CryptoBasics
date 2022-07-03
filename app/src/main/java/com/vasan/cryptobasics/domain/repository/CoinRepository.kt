package com.vasan.cryptobasics.domain.repository

import com.vasan.cryptobasics.data.remote.dto.CoinDTO
import com.vasan.cryptobasics.data.remote.dto.CoinDetailsDTO

interface CoinRepository {

    suspend fun getCoins(): List<CoinDTO>
    suspend fun getCoinById(coinId: String): CoinDetailsDTO

}