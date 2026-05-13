package es.jshcd.edadosea.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import es.jshcd.edadosea.R

@Composable
fun AboutHeader(
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