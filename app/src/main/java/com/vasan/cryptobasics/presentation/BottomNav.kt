package com.vasan.cryptobasics.presentation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.twotone.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.vasan.cryptobasics.presentation.ui.theme.ColorPrimary
import com.vasan.cryptobasics.presentation.ui.theme.DarkGray
import com.vasan.cryptobasics.presentation.ui.theme.MediumGray
import com.vasan.cryptobasics.presentation.ui.theme.TextWhite

sealed class BottomNavItem(
    val route: String,
    val titleResId: String,
    val icon: ImageVector
){
    object Home: BottomNavItem(
        route = Screen.CoinListScreen.route,
        titleResId = "Home",
        icon = Icons.Default.Home
    )
    object News: BottomNavItem(
        route = Screen.NewsScreen.route,
        titleResId = "Crypto News",
        icon = Icons.TwoTone.List
    )
}

@Composable
fun BottomNav(navController: NavController){
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.News
    )
    BottomNavigation(
        backgroundColor = DarkGray,
        contentColor = TextWhite
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(
                    imageVector = item.icon,
                    contentDescription = item.titleResId)
                 },
                label = { Text(text = item.titleResId) },
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