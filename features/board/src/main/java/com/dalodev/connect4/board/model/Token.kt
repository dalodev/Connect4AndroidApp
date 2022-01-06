package com.dalodev.connect4.board.model

import androidx.compose.ui.graphics.Color

data class Token(
    val id: String,
    var selected: Boolean = false,
    var color: Color = Color.Red
)