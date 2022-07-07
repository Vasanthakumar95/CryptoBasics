package com.vasan.cryptobasics.domain.repository

import com.vasan.cryptobasics.data.remote.CoinPaprikaApi
import com.vasan.cryptobasics.data.remote.dto.CoinDTO
import com.vasan.cryptobasics.data.remote.dto.CoinDetailsDTO
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDTO> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDTO {
        return api.getCoinById(coinId)
    }
}