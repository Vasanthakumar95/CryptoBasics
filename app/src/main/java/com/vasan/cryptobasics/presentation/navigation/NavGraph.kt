package com.vasan.cryptobasics.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vasan.cryptobasics.presentation.Screen
import com.vasan.cryptobasics.presentation.coin_details.CoinDetailsScreen
import com.vasan.cryptobasics.presentation.coin_list.components.CoinListScreen
import com.vasan.cryptobasics.presentation.splash.SplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ){
        composable(
            route = Screen.SplashScreen.route
        ){
            SplashScreen(navController)
        }
        composable(
            route = Screen.CoinListScreen.route
        ){
            CoinListScreen(navController)
        }
        composable(
            route = Screen.CoinDetailsScreen.route + "/{coinId}"
        ){
            CoinDetailsScreen()
        }
    }
}