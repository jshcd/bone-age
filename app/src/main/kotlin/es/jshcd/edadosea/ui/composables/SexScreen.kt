package es.jshcd.edadosea.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import es.jshcd.edadosea.R
import es.jshcd.edadosea.ui.PatientState

@Composable
fun SexScreen(
    modifier: Modifier,
    state: PatientState
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.indicate_patient_sex)
        )

        val expanded = remember { mutableStateOf(false) }
        SexSelector(
            expanded = expanded,
            state = state
        )
    }
}