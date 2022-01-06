package com.dalodev.connect4.board

import androidx.navigation.NavController
import com.dalodev.connect4.ui.base.navigation.Navigator

interface BoardNavigator : Navigator {
    fun goBack(navController: NavController?)
}