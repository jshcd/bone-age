package es.jshcd.edadosea.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import es.jshcd.edadosea.R
import es.jshcd.edadosea.ui.theme.BoneAgeTheme

@Composable
fun AboutScreen(
    versionName: String,
    versionNumber: Int,
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
                title = { Text(text = stringResource(id = R.string.title_activity_about)) }
            )
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

@Composable
private fun AboutHeader(
    versionName: String,
    versionNumber: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher),
                contentDescription = "logo"
            )
        }
        Column {
            Text(text = stringResource(id = R.string.app_name))
            Text(text = stringResource(id = R.string.version, versionName, versionNumber))
        }
    }
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