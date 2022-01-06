package com.dalodev.connect4.board.model

import androidx.compose.ui.graphics.Color

class GameBoard(val views: Map<String, Token>, private val players: Map<Int, Color>) {
    val board = createBoard() // List of Columns
    var message: String = "Player 1" //by default
    var playerTurn: Color? = null

    private fun createBoard(): MutableList<Column> {
        val board = mutableListOf<Column>()
        for (i in 0 until 7) {
            val col = Column("$i")
            board.add(col)
        }
        return board
    }

    fun reset() {
        // Resets all values in 2D array to 0
        for (col in board) {
            col.reset()
            message = "Player 1"
            playerTurn = players[0]
        }
    }

    fun addPiece(col: Int, player: Int): Boolean {
        // update 2D array
        val row = board[col].addPiece(player)

        // update display
        if (row >= 0) {
            val view = views["$row$col"]
            val drawable = players[player]
            if (view != null && drawable != null) {
                view.selected = true
                view.color = drawable
                return true
            }
        }
        return false
    }

    fun fourInARow(): Boolean {
        //Search 2D array left to right, bottom to top
        // Loop through columns
        for (i in 0 until board.size) {

            for (j in 0 until board[i].stack.size) {
                // Check if not empty
                if (getValue(i, j) == 0) break
                if (checkAllAdjacent(i, j)) return true
            }
        }
        return false
    }

    private fun getValue(x: Int, y: Int): Int {
        return try {
            board[x].stack[y]
        } catch (e: IndexOutOfBoundsException) {
            0
        }
    }

    private fun check(x: Int, y: Int, dx: Int, dy: Int): Boolean {
        for (i in 1..4) {
            if (!checkAdjacent(x, y, x + (i * dx), y + (i * dy))) {
                break
            } else if (i == 3) {
                return true
            }
        }
        return false
    }

    private fun checkAdjacent(x: Int, y: Int, x1: Int, y1: Int): Boolean {
        return (getValue(x, y) == getValue(x1, y1))
    }

    private fun checkAllAdjacent(x: Int, y: Int): Boolean {
        return (check(x, y, 0, 1) or
                check(x, y, 1, 1) or
                check(x, y, 1, 0) or
                check(x, y, 1, -1) or
                check(x, y, 0, -1) or
                check(x, y, -1, -1) or
                check(x, y, -1, 0) or
                check(x, y, -1, 1))
    }
}