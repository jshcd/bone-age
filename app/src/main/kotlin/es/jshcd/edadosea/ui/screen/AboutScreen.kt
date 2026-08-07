package es.jshcd.edadosea.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import es.jshcd.edadosea.R
import es.jshcd.edadosea.ui.composables.AboutHeader
import es.jshcd.edadosea.ui.theme.BoneAgeTheme

@Composable
fun AboutScreen(
    versionName: String,
    versionNumber: Int,
    onBackArrowPressed: () -> Unit
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
                    title = { Text(text = stringResource(id = R.string.title_activity_about)) },
                    elevation = 0.dp
                )
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                AboutHeader(
                    versionName = versionName,
                    versionNumber = versionNumber
                )
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = stringResource(id = R.string.about_text)
                )
            }
        }
    )
}

@PreviewLightDark
@Composable
fun AboutScreenPreview() {
    BoneAgeTheme {
        AboutScreen(
            versionName = "1.1",
            versionNumber = 2,
            onBackArrowPressed = {}
        )
    }
}