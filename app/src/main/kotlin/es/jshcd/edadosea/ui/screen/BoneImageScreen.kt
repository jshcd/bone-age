package es.jshcd.edadosea.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import es.jshcd.edadosea.R
import es.jshcd.edadosea.ui.PatientState
import es.jshcd.edadosea.ui.getBoneById
import es.jshcd.edadosea.ui.getDrawableIdByBone

@Composable
fun BoneImageScreen(
    state: PatientState,
    onBackArrowPressed: () -> Unit,
    onActionButtonClick: (String) -> Unit
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
                title = { Text(text = stringResource(id = R.string.title_activity_image_detail, stringResource(id = getBoneById(state.selectedBone)))) },
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
            ZoomableImage(
                paddingValues = paddingValues,
                resourceId = getDrawableIdByBone(state.selectedBone)
            )
        }
    )
}

@Composable
private fun ZoomableImage(
    paddingValues: PaddingValues,
    resourceId: Int
) {
    val scale = remember { mutableStateOf(1f) }
    val rotationState = remember { mutableStateOf(1f) }
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .clip(RectangleShape) // Clip the box content
            .fillMaxSize() // Give the size you want...
            .pointerInput(Unit) {
                detectTransformGestures { centroid, pan, zoom, rotation ->
                    scale.value *= zoom
                    rotationState.value += rotation
                }
            }
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.Center) // keep the image centralized into the Box
                .graphicsLayer(
                    // adding some zoom limits (min 50%, max 200%)
                    scaleX = maxOf(.5f, minOf(3f, scale.value)),
                    scaleY = maxOf(.5f, minOf(3f, scale.value)),
                    rotationZ = rotationState.value
                ),
            contentDescription = null,
            painter = painterResource(resourceId)
        )
    }
}

@Preview
@Composable
private fun BoneImageScreenPreview() {
    BoneImageScreen(
        state = PatientState(),
        onBackArrowPressed = {},
        onActionButtonClick = {}
    )
}