package com.dalodev.connect4.ui.base.navigation

import android.content.Context
import androidx.navigation.NavController

typealias NavigationCommand = NavController.(Context) -> Unit
