package com.dalodev.connect4.board.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dalodev.connect4.board.state.BoardUiState
import com.dalodev.connect4.ui.theme.Connect4Theme

@ExperimentalFoundationApi
@Composable
internal fun Board(state: BoardUiState, onReset: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        when (state) {
            is BoardUiState.GenerateGame -> loadGame(state, onReset)
            BoardUiState.Loading -> Loading()
        }
    }
}

@ExperimentalFoundationApi
@Composable
private fun loadGame(state: BoardUiState.GenerateGame, onReset: () -> Unit) {
    PlayerText(state.gameBoard.message)
    Columns(columns = state.columns)
    GameBoard(gameBoard = state.gameBoard)
    ExtendedFloatingActionButton(
        modifier = Modifier.padding(top = 24.dp),
        text = { Text("Reset") },
        onClick = { onReset() }
    )
}

@Composable
private fun Loading() {
    CircularProgressIndicator()
}

@ExperimentalFoundationApi
@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    Connect4Theme {

    }
}

