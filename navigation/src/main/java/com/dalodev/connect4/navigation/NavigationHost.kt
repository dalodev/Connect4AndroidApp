package com.dalodev.connect4.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dalodev.connect4.board.BoardRoute
import com.dalodev.connect4.board.BoardScreen
import com.dalodev.connect4.dashboard.DashboardRoute
import com.dalodev.connect4.dashboard.DashboardScreen

@ExperimentalFoundationApi
@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = DashboardRoute.SCREEN
    ) {
        composable(route = DashboardRoute.SCREEN) {
            DashboardScreen(navController = navController)
        }
        composable(route = BoardRoute.SCREEN) {
            BoardScreen(navController = navController)
        }
    }
}