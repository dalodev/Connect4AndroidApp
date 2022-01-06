package com.dalodev.connect4.navigation.dashboard

import androidx.navigation.NavController
import com.dalodev.connect4.board.BoardRoute
import com.dalodev.connect4.dashboard.DashboardNavigator
import com.paulrybitskyi.hiltbinder.BindType
import javax.inject.Inject

@BindType(installIn = BindType.Component.SINGLETON)
internal class DashboardNavigation @Inject constructor(
) : DashboardNavigator {

    override fun goToBoard(navController: NavController?) {
        navController?.navigate(BoardRoute.SCREEN)
    }
}