package es.jshcd.edadosea.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import es.jshcd.edadosea.R
import es.jshcd.edadosea.ui.calculateNumberOfMonthsFromAge
import es.jshcd.edadosea.ui.calculateNumberOfYearsFromAge
import es.jshcd.edadosea.ui.theme.BoneAgeTheme

@Composable
fun ResultScreen(
    onActionButtonClick: (String) -> Unit,
    onBackArrowPressed: () -> Unit,
    onNewCalculationClick: () -> Unit,
    patientAge: Float?,
    error: String?
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBackArrowPressed) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )

                    }
                },
                title = { Text(text = stringResource(id = R.string.title_activity_result)) },
                actions = {
                    IconButton(
                        onClick = {
                            onActionButtonClick("About")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = stringResource(
                                id = R.string.action_about
                            )
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(
                    top = paddingValues.calculateTopPadding() + 8.dp,
                    bottom = paddingValues.calculateBottomPadding() + 8.dp,
                    start = paddingValues.calculateStartPadding(LayoutDirection.Ltr) + 8.dp,
                    end = paddingValues.calculateEndPadding(LayoutDirection.Ltr) + 8.dp
                )
            ) {
                if (error != "OK") {
                    Error()
                } else {
                    Age(
                        patientAge = patientAge
                    )
                }
            }
        },
        bottomBar = {
            if (error == "OK") {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Button(
                        onClick = onNewCalculationClick
                    ) {
                        Text(
                            text = stringResource(id = R.string.new_calculation).uppercase()
                        )
                    }
                }
            }
        }
    )
}

@Composable
private fun Error() {
    Text(
        text = stringResource(id = R.string.error_patient_is_adult),
        color = Color.Red
    )
}

@Composable
private fun Age(
    patientAge: Float?
) {
    if (patientAge != null) {
        Text(
            text = stringResource(
                id = R.string.patient_bone_age_is,
                calculateNumberOfYearsFromAge(patientAge),
                calculateNumberOfMonthsFromAge(patientAge)
            )
        )
    } else {
        Text(text = stringResource(id = R.string.error_the_patient_age_could_not_be_calculated))
    }
}

@PreviewLightDark
@Composable
private fun ResultScreenPreview() {
    BoneAgeTheme {
        ResultScreen(
            onActionButtonClick = { _ -> },
            onBackArrowPressed = { },
            onNewCalculationClick = { },
            patientAge = 2.7f,
            error = "OK"
        )
    }
}

@PreviewLightDark
@Composable
private fun ResultScreenErrorPreview() {
    BoneAgeTheme {
        ResultScreen(
            onActionButtonClick = { _ -> },
            onBackArrowPressed = { },
            onNewCalculationClick = { },
            patientAge = 2.7f,
            error = "Error"
        )
    }
}