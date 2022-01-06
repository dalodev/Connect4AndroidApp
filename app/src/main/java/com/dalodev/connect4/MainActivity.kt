package com.dalodev.connect4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.dalodev.connect4.navigation.NavigationHost
import com.dalodev.connect4.ui.theme.Connect4Theme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Connect4Theme {
                Surface(color = MaterialTheme.colors.background) {
                    NavigationHost()
                }
            }
        }
    }
}