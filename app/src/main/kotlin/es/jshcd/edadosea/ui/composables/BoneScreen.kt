package es.jshcd.edadosea.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import es.jshcd.edadosea.R
import es.jshcd.edadosea.ui.PatientState
import es.jshcd.edadosea.ui.getBoneById
import es.jshcd.edadosea.ui.getDrawableIdByBone

@Composable
fun BoneScreen(
    modifier: Modifier,
    state: PatientState,
    onShowFullScreenImage: () -> Unit
) {
    Column(
        modifier = modifier.padding(
            8.dp
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = getBoneById(state.selectedBone))
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.select_a_value)
            )

            val expanded = remember { mutableStateOf(false) }
            BoneSelector(
                expanded = expanded,
                state = state
            )
        }

        Image(
            modifier = Modifier.clickable {
                onShowFullScreenImage()
            },
            painter = painterResource(id = getDrawableIdByBone(state.selectedBone)),
            contentDescription = "logo"
        )
    }
}