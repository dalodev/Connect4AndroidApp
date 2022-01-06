package com.dalodev.connect4.dashboard

import com.dalodev.connect4.ui.base.events.Route

sealed class DashboardRoute : Route {

    companion object {
        const val SCREEN = "dashboard"
    }
}