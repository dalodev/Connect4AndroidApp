package com.dalodev.connect4.board.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dalodev.connect4.board.model.Token

@Composable
fun BoardButton(token: Token?) {
    val color = if (token?.selected == true) {
        token.color
    } else {
        Color.White
    }
    Button(
        onClick = { },
        modifier = Modifier
            .size(50.dp)
            .padding(1.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        shape = CircleShape,
        border = BorderStroke(1.dp, Color.Blue),
        contentPadding = PaddingValues(0.dp),  //avoid the little icon
    ) {
        Text(text = token?.id ?: "")
    }
}