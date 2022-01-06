package com.dalodev.connect4.ui.base.navigation

import com.dalodev.connect4.ui.base.events.Route
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

@ViewModelScoped
class NavigationDispatcher @Inject constructor() {

    private val _routeChannel = Channel<Route>(Channel.BUFFERED)

    fun emit(route: Route) {
        _routeChannel.trySend(route)
    }
}