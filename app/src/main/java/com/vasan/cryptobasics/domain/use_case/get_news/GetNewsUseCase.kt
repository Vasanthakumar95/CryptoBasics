package com.vasan.cryptobasics.domain.use_case.get_news

import android.util.Log
import com.vasan.cryptobasics.common.Resource
import com.vasan.cryptobasics.data.remote.dto.NewsDTO
import com.vasan.cryptobasics.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: NewsRepository
){
    operator fun invoke(): Flow<Resource<NewsDTO>> = flow {
        try{
            emit(Resource.Loading())
            val news = repository.getNews()
            Log.e("GETNEWS", news.toString())
            emit(Resource.Success(news))
        } catch (e: HttpException){
            Log.e("GETNEWS", e.toString())
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error Occurred"))
        } catch (e: IOException){
            Log.e("GETNEWS", e.toString())
            emit(Resource.Error("Server Down"))
        }
    }
}