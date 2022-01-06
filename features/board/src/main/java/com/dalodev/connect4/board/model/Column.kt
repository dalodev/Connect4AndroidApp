package com.dalodev.connect4.board.model

class Column(val id: String) {
    val stack = mutableListOf(0, 0, 0, 0, 0, 0)
    var index = 0
    var onClick: (() -> Unit)? = null

    fun addPiece(piece: Int): Int {
        return if (index < 6) {
            stack[index] = piece
            index++
            index - 1
        } else {
            -1
        }
    }

    fun reset() {
        index = 0
        for (i in stack.indices) stack[i] = 0
    }
}