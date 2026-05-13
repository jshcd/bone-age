package es.jshcd.edadosea.ui.screen

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import es.jshcd.edadosea.R
import es.jshcd.edadosea.ui.PatientState
import es.jshcd.edadosea.ui.composables.ZoomableImage
import es.jshcd.edadosea.ui.getBoneById
import es.jshcd.edadosea.ui.getDrawableIdByBone
import es.jshcd.edadosea.ui.theme.BoneAgeTheme

@Composable
fun BoneImageScreen(
    state: PatientState,
    onBackArrowPressed: () -> Unit
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
                title = { Text(text = stringResource(id = R.string.title_activity_image_detail, stringResource(id = getBoneById(state.selectedBone)))) }
            )
        },
        content = { paddingValues ->
            ZoomableImage(
                paddingValues = paddingValues,
                resourceId = getDrawableIdByBone(state.selectedBone)
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun BoneImageScreenPreview() {
    BoneAgeTheme {
        BoneImageScreen(
            state = PatientState(),
            onBackArrowPressed = {}
        )
    }
}