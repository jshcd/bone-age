package es.jshcd.edadosea.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import es.jshcd.edadosea.R
import es.jshcd.edadosea.core.NUMBER_OF_BONES
import es.jshcd.edadosea.ui.PatientState
import es.jshcd.edadosea.ui.theme.BoneAgeTheme

@Composable
fun NavigationButtons(
    state: PatientState,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    onCalculateBoneAgeClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .navigationBarsPadding()
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
                    PreviousButton(
                        onClick = onPreviousClick
                    )
                }
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End
            ) {
                if (state.selectedBone < NUMBER_OF_BONES) {
                    NextButton(
                        onClick = onNextClick
                    )
                }
            }
        }
        if (state.selectedBone == NUMBER_OF_BONES) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                CalculateBoneAgeButton(
                    onClick = onCalculateBoneAgeClick
                )
            }
        }
    }
}

@Composable
private fun PreviousButton(onClick: () -> Unit) {
    BoneAgeButton(
        onClick = onClick,
        textResourceId = R.string.previous
    )
}

@Composable
private fun NextButton(onClick: () -> Unit) {
    BoneAgeButton(
        onClick = onClick,
        textResourceId = R.string.next
    )
}

@Composable
private fun CalculateBoneAgeButton(onClick: () -> Unit) {
    BoneAgeButton(
        onClick = onClick,
        textResourceId = R.string.calculate_bone_age
    )
}

@Composable
private fun BoneAgeButton(
    onClick: () -> Unit,
    textResourceId: Int
) {
    Button(
        onClick = onClick
    ) {
        Text(
            text = stringResource(id = textResourceId).uppercase())
    }
}

@PreviewLightDark
@Composable
private fun NavigationButtonsNextPreview() {
    BoneAgeTheme {
        NavigationButtons(
            state = PatientState(),
            onPreviousClick = {},
            onNextClick = {},
            onCalculateBoneAgeClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun NavigationButtonsPreviousAndNextPreview() {
    BoneAgeTheme {
        NavigationButtons(
            state = PatientState(
                selectedBone = 10
            ),
            onPreviousClick = {},
            onNextClick = {},
            onCalculateBoneAgeClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun NavigationButtonsPreviousAndCalculateBoneAgePreview() {
    BoneAgeTheme {
        NavigationButtons(
            state = PatientState(
                selectedBone = 13
            ),
            onPreviousClick = {},
            onNextClick = {},
            onCalculateBoneAgeClick = {}
        )
    }
}