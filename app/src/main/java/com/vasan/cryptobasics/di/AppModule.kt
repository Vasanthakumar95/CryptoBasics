package com.vasan.cryptobasics.di

import com.vasan.cryptobasics.common.Constants
import com.vasan.cryptobasics.data.remote.CoinPaprikaApi
import com.vasan.cryptobasics.data.remote.CoinStatsApi
import com.vasan.cryptobasics.domain.repository.CoinRepository
import com.vasan.cryptobasics.domain.repository.CoinRepositoryImpl
import com.vasan.cryptobasics.domain.repository.NewsRepository
import com.vasan.cryptobasics.domain.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesPaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesCoinStatsApi(): CoinStatsApi{
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_2)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CoinStatsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(api: CoinStatsApi): NewsRepository{
        return NewsRepositoryImpl(api)
    }
}