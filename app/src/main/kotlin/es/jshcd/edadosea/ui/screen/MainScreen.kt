package es.jshcd.edadosea.ui.screen

import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.LayoutDirection
import es.jshcd.edadosea.R
import es.jshcd.edadosea.core.NUMBER_OF_BONES
import es.jshcd.edadosea.ui.composables.NavigationButtons
import es.jshcd.edadosea.ui.PatientState
import es.jshcd.edadosea.ui.composables.BoneScreen
import es.jshcd.edadosea.ui.composables.SexScreen
import es.jshcd.edadosea.ui.theme.BoneAgeTheme

@Composable
fun MainScreen(
    state: PatientState,
    onActionButtonClick: (String) -> Unit,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    onCalculateBoneAgeClick: () -> Unit,
    onShowFullScreenImage: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(text = stringResource(id = R.string.app_name))},
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
            if (state.selectedBone < NUMBER_OF_BONES) {
                BoneScreen(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = paddingValues.calculateTopPadding(),
                            bottom = paddingValues.calculateBottomPadding(),
                            start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                            end = paddingValues.calculateEndPadding(LayoutDirection.Ltr)
                        ),
                    state = state,
                    onShowFullScreenImage = onShowFullScreenImage
                )
            } else {
                SexScreen(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = paddingValues.calculateTopPadding(),
                            bottom = paddingValues.calculateBottomPadding(),
                            start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                            end = paddingValues.calculateEndPadding(LayoutDirection.Ltr)
                        ),
                    state = state
                )
            }
        },
        bottomBar = {
            NavigationButtons(
                state = state,
                onPreviousClick = onPreviousClick,
                onNextClick = onNextClick,
                onCalculateBoneAgeClick = onCalculateBoneAgeClick
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun MainScreenRadiusPreview() {
    BoneAgeTheme {
        MainScreen(
            state = PatientState(),
            onActionButtonClick = {},
            onPreviousClick = {},
            onNextClick = {},
            onCalculateBoneAgeClick = {},
            onShowFullScreenImage = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun MainScreenSexSelectionPreview() {
    BoneAgeTheme {
        MainScreen(
            state = PatientState(
                selectedBone = 13
            ),
            onActionButtonClick = {},
            onPreviousClick = {},
            onNextClick = {},
            onCalculateBoneAgeClick = {},
            onShowFullScreenImage = {}
        )
    }
}