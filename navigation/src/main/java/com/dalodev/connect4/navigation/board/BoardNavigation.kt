package com.dalodev.connect4.navigation.board

import androidx.navigation.NavController
import com.dalodev.connect4.board.BoardNavigator
import com.dalodev.connect4.board.BoardRoute
import com.dalodev.connect4.dashboard.DashboardNavigator
import com.paulrybitskyi.hiltbinder.BindType
import javax.inject.Inject

@BindType(installIn = BindType.Component.SINGLETON)
internal class BoardNavigation @Inject constructor(
) : BoardNavigator {

    override fun goBack(navController: NavController?) {
        navController?.navigateUp()
    }
}