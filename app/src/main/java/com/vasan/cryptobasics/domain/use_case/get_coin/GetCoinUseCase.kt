package com.vasan.cryptobasics.domain.use_case.get_coin

import android.util.Log
import com.vasan.cryptobasics.common.Resource
import com.vasan.cryptobasics.data.remote.dto.toCoinDetails
import com.vasan.cryptobasics.domain.model.CoinDetails
import com.vasan.cryptobasics.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoinById(coinId).toCoinDetails()
            Log.e("xxx", coins.coinId)
            emit(Resource.Success(coins))
        } catch (e: HttpException){
            Log.e("xxx", e.message())
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error Occurred"))
        } catch (e: IOException){
            Log.e("xxx", e.message.toString())
            emit(Resource.Error("Server Down"))
        }
    }

}