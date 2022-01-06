package com.dalodev.connect4.board.state

import com.dalodev.connect4.board.model.Column
import com.dalodev.connect4.board.model.GameBoard

sealed class BoardUiState {
    object Loading : BoardUiState()
    data class GenerateGame(val columns: List<Column>, val gameBoard: GameBoard) : BoardUiState()
}