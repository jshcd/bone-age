package es.jshcd.edadosea.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import es.jshcd.edadosea.R
import es.jshcd.edadosea.ui.calculateNumberOfMonthsFromAge
import es.jshcd.edadosea.ui.calculateNumberOfYearsFromAge

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
                            imageVector = Icons.Filled.ArrowBack,
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
            val padding = paddingValues

            if (error != "OK") {
                Error()
            } else {
                Age(
                    patientAge = patientAge
                )
            }
        },
        bottomBar = {
            if (error == "OK") {
                Button(
                    onClick = onNewCalculationClick
                ) {
                    Text(
                        text = stringResource(id = R.string.new_calculation)
                    )
                }
            }
        }
    )
}

@Composable
private fun Error() {
    Column {
        Text(
            text = stringResource(id = R.string.error_patient_is_adult),
            color = Color.Red
        )
    }
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
        Text(text = "Patient age could not be calculated!")
    }
}

