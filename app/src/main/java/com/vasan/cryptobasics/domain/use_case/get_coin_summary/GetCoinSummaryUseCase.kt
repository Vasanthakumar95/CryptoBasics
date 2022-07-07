package com.vasan.cryptobasics.domain.use_case.get_coin_summary

import android.util.Log
import com.vasan.cryptobasics.common.Resource
import com.vasan.cryptobasics.data.remote.dto.CoinSummaryDTO
import com.vasan.cryptobasics.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetCoinSummaryUseCase @Inject constructor(
    private val repository: NewsRepository
){
    operator fun invoke(): Flow<Resource<CoinSummaryDTO>> = flow {
        try {
            emit(Resource.Loading())
            val coinSummary = repository.getCoinSummary()
            Log.e("GETCOINSUMMARY", coinSummary.toString())
            emit(Resource.Success(coinSummary))
        }catch (e: HttpException){
            Log.e("GETCOINSUMMARY", e.toString())
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error Occurred"))
        } catch (e: IOException){
            Log.e("GETCOINSUMMARY", e.toString())
            emit(Resource.Error("Server Down"))
        }
    }
}