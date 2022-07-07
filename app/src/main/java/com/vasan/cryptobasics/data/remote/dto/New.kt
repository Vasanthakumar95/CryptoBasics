package com.vasan.cryptobasics.data.remote.dto

data class New(
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