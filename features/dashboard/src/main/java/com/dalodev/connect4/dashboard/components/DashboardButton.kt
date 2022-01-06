package com.dalodev.connect4.dashboard.components

import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dalodev.connect4.ui.theme.Connect4Theme

@Composable
fun Button(name: String, onClick: () -> Unit) {
    ExtendedFloatingActionButton(
            onClick = onClick,
            text = { Text(name) }
    )
}

@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    Connect4Theme {
        Button("Play") {}
    }
}