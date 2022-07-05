package com.vasan.cryptobasics.domain.model

import com.vasan.cryptobasics.data.remote.dto.Links
import com.vasan.cryptobasics.data.remote.dto.TeamMember

class CoinDetails (
    val coinId: String,
    val name: String,
    val description: String,
    val symbols: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>,
    val links: Links
)