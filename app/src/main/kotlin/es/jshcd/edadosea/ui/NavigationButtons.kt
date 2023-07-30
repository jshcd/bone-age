package es.jshcd.edadosea.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.jshcd.edadosea.R
import es.jshcd.edadosea.core.NUMBER_OF_BONES

@Composable
fun NavigationButtons(
    state: PatientState,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    onCalculateBoneAgeClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                if (state.selectedBone in 1..NUMBER_OF_BONES) {
                    Button(
                        onClick = onPreviousClick
                    ) {
                        Text(text = stringResource(id = R.string.previous))
                    }
                }
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End
            ) {
                if (state.selectedBone < NUMBER_OF_BONES) {
                    Button(
                        onClick = onNextClick
                    ) {
                        Text(text = stringResource(id = R.string.next))
                    }
                }
            }
        }
        if (state.selectedBone == NUMBER_OF_BONES) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = onCalculateBoneAgeClick
                ) {
                    Text(text = stringResource(id = R.string.calculate_bone_age))
                }
            }
        }
    }
}

@Preview
@Composable
private fun NavigationButtonsPreview() {
    NavigationButtons(
        state = PatientState(),
        onPreviousClick = {},
        onNextClick = {},
        onCalculateBoneAgeClick = {}
    )
}