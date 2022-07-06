package com.vasan.cryptobasics.presentation.coin_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowRow
import com.vasan.cryptobasics.presentation.Screen
import com.vasan.cryptobasics.presentation.coin_details.components.CoinTag
import com.vasan.cryptobasics.presentation.coin_details.components.TeamListItem
import com.vasan.cryptobasics.presentation.coin_details.components.VideoPlayer
import com.vasan.cryptobasics.presentation.coin_details.components.WebLinkListItem
import com.vasan.cryptobasics.presentation.ui.theme.ColorPrimary
import com.vasan.cryptobasics.presentation.ui.theme.DarkGray
import com.vasan.cryptobasics.presentation.ui.theme.MediumGray
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun CoinDetailsScreen(
    navController: NavController,
    viewModel: CoinDetailsViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()){
        state.coin?.let { coin ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(15.dp)
            ) {
                item {
                    if (!coin.links.youtube.isNullOrEmpty()){
                        Column(modifier = Modifier.aspectRatio(16 / 9f)) {
                            VideoPlayer(url = coin.links.youtube[0])
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbols})",
                            style = MaterialTheme.typography.h4,
                            modifier = Modifier.weight(8f)
                        )
                        Text(
                            text = if (coin.isActive) "active" else "inactive",
                            color = if (coin.isActive) ColorPrimary else MediumGray,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(CenterVertically)
                                .weight(2f)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = coin.description,
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h4
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coin.tags.forEach { tag ->
                            CoinTag(tag = tag)
                        }
                    }
                    if (!coin.webLinks.isEmpty()){
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Useful Links",
                            style = MaterialTheme.typography.h4
                        )
                        Text(
                            text = "Click to read more",
                            style = MaterialTheme.typography.body1
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        LazyRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
                        ){
                            items(state.coin.webLinks){ link ->
                                WebLinkListItem(
                                    link = link,
                                    onItemClick = {
                                        /**
                                         * since navigation params is treated as a link/url
                                         * when passing normal URL as parameters in navigation it throws an error
                                         * encode it in URL encoder to avoid it reading the url we passed to it
                                         * as a link
                                         */
                                        val encodedUrl = URLEncoder.encode(link, StandardCharsets.UTF_8.toString())
                                        navController.navigate(Screen.WebViewerScreen.route + "/${encodedUrl}")
                                    }
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                    if(!coin.team.isEmpty()){
                        Text(
                            text = "Team Members",
                            style = MaterialTheme.typography.h4
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
                if(!coin.team.isEmpty()){
                    items(coin.team){ teamMember ->
                        TeamListItem(
                            teamMember = teamMember,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        )
                        Divider()
                    }
                }
            }
        }
        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}