package es.jshcd.edadosea.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import es.jshcd.edadosea.R
import es.jshcd.edadosea.ui.composables.AgeComposable
import es.jshcd.edadosea.ui.composables.ErrorComposable
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
            Surface(color = MaterialTheme.colors.primary) {
                TopAppBar(
                    modifier = Modifier.statusBarsPadding(),
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
                    },
                    elevation = 0.dp
                )
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(
                        top = paddingValues.calculateTopPadding() + 8.dp,
                        bottom = paddingValues.calculateBottomPadding() + 8.dp,
                        start = paddingValues.calculateStartPadding(LayoutDirection.Ltr) + 8.dp,
                        end = paddingValues.calculateEndPadding(LayoutDirection.Ltr) + 8.dp
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (error != "OK") {
                    ErrorComposable(
                        error = stringResource(id = R.string.error_patient_is_adult)
                    )
                } else {
                    if (patientAge == null) {
                        ErrorComposable(
                            error = stringResource(id = R.string.error_the_patient_age_could_not_be_calculated)
                        )
                    } else {
                        AgeComposable(
                            patientAge = patientAge
                        )
                    }
                }
            }
        },
        bottomBar = {
            if (error == "OK") {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .navigationBarsPadding()
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