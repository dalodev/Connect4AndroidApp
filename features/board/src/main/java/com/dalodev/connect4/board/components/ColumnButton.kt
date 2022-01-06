package com.dalodev.connect4.board.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dalodev.connect4.board.model.Column

@Composable
fun ColumnButton(column: Column) {
    Button(
        onClick = { column.onClick?.invoke() },
        modifier = Modifier
            .then(Modifier.size(50.dp))
            .padding(1.dp),  //avoid the oval shape
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),  //avoid the little icon
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
    ) {
        Text(text = column.id)
    }
}