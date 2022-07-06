package com.vasan.cryptobasics.presentation

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.vasan.cryptobasics.R
import com.vasan.cryptobasics.presentation.ui.theme.ColorPrimary
import com.vasan.cryptobasics.presentation.ui.theme.DarkGray
import com.vasan.cryptobasics.presentation.ui.theme.MediumGray
import com.vasan.cryptobasics.presentation.ui.theme.TextWhite

@Composable
fun BottomNav(navController: NavController){
    val items = listOf(
        Screen.CoinListScreen,
        Screen.NewsScreen
    )
    BottomNavigation(
        backgroundColor = DarkGray,
        contentColor = TextWhite
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { if (item.route == Screen.CoinListScreen.route) (Icon(painterResource(id = R.drawable.ic_icon_stripped),null, modifier = Modifier.size(20.dp)))
                else (Icon(Icons.Default.List, null, modifier = Modifier.size(20.dp)))},
                label = { if (item.route == Screen.CoinListScreen.route) Text(text = "HOME", fontSize = 12.sp) else Text(text = "NEWS", fontSize = 12.sp)},
                selectedContentColor = ColorPrimary,
                unselectedContentColor = MediumGray,
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route){
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}