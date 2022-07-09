package com.vasan.cryptobasics.presentation.news_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vasan.cryptobasics.presentation.news_screen.components.NewsListItems
import com.vasan.cryptobasics.presentation.Screen
import com.vasan.cryptobasics.presentation.ui.theme.DarkGray
import com.vasan.cryptobasics.presentation.ui.theme.MediumGray
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun NewsScreen(
    navController: NavController,
    viewModel: NewsViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(modifier = Modifier.fillMaxSize()){
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .background(DarkGray)){
                items(state.news){ news ->
                    NewsListItems(
                        news = news,
                        onItemClick = {
                            val encodedUrl = URLEncoder.encode(news.link, StandardCharsets.UTF_8.toString())
                            navController.navigate(Screen.WebViewerScreen.route + "/${encodedUrl}")
                        }
                    )
                }
            }
            if (state.error.isNotBlank()){
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
            if (state.isLoading){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
    

}
