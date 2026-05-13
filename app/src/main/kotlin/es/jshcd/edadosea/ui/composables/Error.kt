package es.jshcd.edadosea.ui.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import es.jshcd.edadosea.R

@Composable
fun ErrorComposable() {
    Text(
        text = stringResource(id = R.string.error_patient_is_adult),
        color = Color.Red
    )
}