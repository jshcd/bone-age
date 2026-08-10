package es.jshcd.edadosea.ui.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ErrorComposable(error: String) {
    Text(
        text = error,
        color = Color.Red
    )
}