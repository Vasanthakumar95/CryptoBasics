package com.vasan.cryptobasics.presentation

sealed class Screen(val route: String){
    object SplashScreen: Screen("splash_screen")
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailsScreen: Screen("coin_details_screen")
    object WebViewerScreen: Screen("web_view")
    object NewsScreen: Screen("news_screen")
    object ContactScreen: Screen("contact_screen")
}
