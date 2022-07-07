package com.vasan.cryptobasics.domain.repository

import com.vasan.cryptobasics.data.remote.dto.NewsDTO

interface NewsRepository {
    suspend fun getNews(): NewsDTO
}