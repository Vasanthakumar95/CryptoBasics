package com.vasan.cryptobasics.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.vasan.cryptobasics.presentation.navigation.SetupNavGraph
import com.vasan.cryptobasics.presentation.ui.theme.CryptoBasicsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoBasicsTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
//                SetupNavGraph(navController = navController)
//                Scaffold(bottomBar = { BottomNav(navController) })
                Scaffold(
                    bottomBar = { BottomNav(navController) }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        SetupNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}