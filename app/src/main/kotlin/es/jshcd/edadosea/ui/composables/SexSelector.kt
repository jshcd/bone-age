package es.jshcd.edadosea.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import es.jshcd.edadosea.ui.PatientState
import es.jshcd.edadosea.ui.Sex
import es.jshcd.edadosea.ui.getPossiblePatientSexs

@Composable
fun SexSelector(
    expanded: MutableState<Boolean>,
    state: PatientState
) {
    Column {
        TextField(
            modifier = Modifier.clickable(
                onClick = {
                    expanded.value = !expanded.value
                }
            ),
            value = state.selectedSex.name,
            onValueChange = {

            },
            enabled = false
        )

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { },
        ) {
            val items: List<String> = getPossiblePatientSexs()
            items.forEach { s ->
                DropdownMenuItem(
                    onClick = {
                        state.selectedSex = Sex.valueOf(s)
                        expanded.value = false
                    }
                ) {
                    Text(text = s)
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun SexSelectorPreview() {
    val expanded = remember { mutableStateOf(true) }
    SexSelector(
        expanded = expanded,
        state = PatientState()
    )
}