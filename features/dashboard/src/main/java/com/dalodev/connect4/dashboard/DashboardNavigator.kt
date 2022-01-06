package com.dalodev.connect4.dashboard

import androidx.navigation.NavController
import com.dalodev.connect4.ui.base.navigation.Navigator

interface DashboardNavigator : Navigator {
    fun goToBoard(navController: NavController?)
}