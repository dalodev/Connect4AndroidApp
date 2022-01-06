package com.dalodev.connect4.dashboard

import com.dalodev.connect4.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val navigator: DashboardNavigator
) : BaseViewModel() {

    fun onPlayClicked() {
        navigator.goToBoard(navController)
    }
}