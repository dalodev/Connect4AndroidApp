package com.dalodev.connect4.board

import androidx.compose.ui.graphics.Color
import com.dalodev.connect4.board.model.Column
import com.dalodev.connect4.board.model.GameBoard
import com.dalodev.connect4.board.model.Token
import com.dalodev.connect4.board.state.BoardUiState
import com.dalodev.connect4.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BoardViewModel @Inject constructor(
    private val navigator: BoardNavigator
) : BaseViewModel() {

    private var whoseTurn = 0
        set(value) {
            field = value % 2
        }

    private var gameOver = false

    private val players = setPlayers()
    private val imgViews = getViewsId()
    private var gameBoard = GameBoard(imgViews, players)
    private val columns = getColumns()

    private val _uiState = MutableStateFlow<BoardUiState>(
        BoardUiState.GenerateGame(columns, gameBoard)
    )
    val uiState: StateFlow<BoardUiState>
        get() = _uiState

    private fun getColumns(): List<Column> {
        val columns = mutableListOf<Column>()
        for (col in 0 until 7) {
            columns.add(Column("$col").apply {
                onClick = { columnClicked(col) }
            })
        }
        return columns
    }

    private fun columnClicked(col: Int) {
        if (!gameOver) {
            if (gameBoard.addPiece(col, whoseTurn + 1)) {
                if (!gameOver && gameBoard.fourInARow()) {
                    // Show message with winner message
                    gameBoard.message = "PLAYER ${whoseTurn + 1} WINS!"
                    gameOver = true
                    _uiState.value = BoardUiState.GenerateGame(getColumns(), gameBoard)
                    //TODO save win in database
                }
                whoseTurn++
                gameBoard.message = "Player ${whoseTurn + 1}"
                gameBoard.playerTurn = players[whoseTurn + 1]
                _uiState.value = BoardUiState.GenerateGame(getColumns(), gameBoard)

            }
        }
    }

    private fun setPlayers(): Map<Int, Color> {
        return mapOf(1 to Color.Red, 2 to Color.Yellow)
    }

    private fun getViewsId(): Map<String, Token> {
        return mapOf(
            "50" to Token(id = "50"),
            "51" to Token(id = "51"),
            "52" to Token(id = "52"),
            "53" to Token(id = "53"),
            "54" to Token(id = "54"),
            "55" to Token(id = "55"),
            "56" to Token(id = "56"),
            "40" to Token(id = "40"),
            "41" to Token(id = "41"),
            "42" to Token(id = "42"),
            "43" to Token(id = "43"),
            "44" to Token(id = "44"),
            "45" to Token(id = "45"),
            "46" to Token(id = "46"),
            "30" to Token(id = "30"),
            "31" to Token(id = "31"),
            "32" to Token(id = "32"),
            "33" to Token(id = "33"),
            "34" to Token(id = "34"),
            "35" to Token(id = "35"),
            "36" to Token(id = "36"),
            "20" to Token(id = "20"),
            "21" to Token(id = "21"),
            "22" to Token(id = "22"),
            "23" to Token(id = "23"),
            "24" to Token(id = "24"),
            "25" to Token(id = "25"),
            "26" to Token(id = "26"),
            "10" to Token(id = "10"),
            "11" to Token(id = "11"),
            "12" to Token(id = "12"),
            "13" to Token(id = "13"),
            "14" to Token(id = "14"),
            "15" to Token(id = "15"),
            "16" to Token(id = "16"),
            "00" to Token(id = "00"),
            "01" to Token(id = "01"),
            "02" to Token(id = "02"),
            "03" to Token(id = "03"),
            "04" to Token(id = "04"),
            "05" to Token(id = "05"),
            "06" to Token(id = "06")
        )
    }

    fun goBack() = navigator.goBack(navController)

    fun resetGame() {
        gameBoard = GameBoard(getViewsId(), setPlayers())
        whoseTurn = 0
        gameBoard.reset()
        _uiState.value = BoardUiState.GenerateGame(getColumns(), gameBoard)
    }
}