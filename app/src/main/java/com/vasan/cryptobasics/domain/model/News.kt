package com.vasan.cryptobasics.domain.model

import com.vasan.cryptobasics.data.remote.dto.Coin
import com.vasan.cryptobasics.data.remote.dto.ReactionsCount

class News (
    val coins: List<Coin>,
    val content: Boolean,
    val description: String,
    val feedDate: Long,
    val icon: String,
    val id: String,
    val imgURL: String,
    val link: String,
    val reactionsCount: ReactionsCount,
    val relatedCoins: List<String>,
    val shareURL: String,
    val source: String,
    val sourceLink: String,
    val title: String
)