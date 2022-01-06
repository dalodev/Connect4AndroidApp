package com.dalodev.connect4.board

import com.dalodev.connect4.ui.base.events.Route

sealed class BoardRoute : Route {

    companion object {
        const val SCREEN = "board"
    }

    object Reset : BoardRoute()
}