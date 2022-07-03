package com.vasan.cryptobasics.domain.use_case.get_coins

import com.vasan.cryptobasics.common.Resource
import com.vasan.cryptobasics.data.remote.dto.toCoin
import com.vasan.cryptobasics.domain.model.Coin
import com.vasan.cryptobasics.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow{
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error Occurred"))
        } catch (e: IOException){
            emit(Resource.Error("Server Down"))
        }
    }
}