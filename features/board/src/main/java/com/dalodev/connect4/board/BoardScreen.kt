package com.dalodev.connect4.board

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dalodev.connect4.board.components.Board

@ExperimentalFoundationApi
@Composable
fun BoardScreen(
    navController: NavController,
    viewModel: BoardViewModel = hiltViewModel()
) {
    viewModel.navController = navController

    val state = viewModel.uiState.collectAsState()

    Scaffold(topBar = { BoardTopAppBar { viewModel.goBack() } }
    ) {
        Board(state.value, onReset = viewModel::resetGame)
    }
}

@Composable
fun BoardTopAppBar(onBack: () -> Unit) {
    TopAppBar(
        title = { Text("Connect 4") },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                )
            }
        }
    )
}