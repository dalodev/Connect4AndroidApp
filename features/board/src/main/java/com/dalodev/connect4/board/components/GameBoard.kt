package com.dalodev.connect4.board.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dalodev.connect4.board.model.GameBoard

@ExperimentalFoundationApi
@Composable
fun GameBoard(gameBoard: GameBoard) {
    LazyVerticalGrid(
        modifier = Modifier.background(Color.Blue),
        cells = GridCells.Fixed(7),
        contentPadding = PaddingValues(12.dp),
    ) {
        items(gameBoard.views.toList()) {
            BoardButton(it.second)
        }
    }
}