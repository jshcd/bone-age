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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import es.jshcd.edadosea.R

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
                            imageVector = Icons.Filled.ArrowBack,
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
                Text(text = stringResource(id = R.string.about_text))
            }
        }
    )
}

@Composable
fun AboutHeader(
    versionName: String,
    versionNumber: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
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

@Preview
@Composable
fun AboutHeaderPreview() {
    AboutHeader(
        versionName = "1.1",
        versionNumber = 2
    )
}

@Preview
@Composable
fun AboutScreenPreview() {
    AboutScreen(
        versionName = "1.1",
        versionNumber = 2,
        onBackArrowPressed = {}
    )
}