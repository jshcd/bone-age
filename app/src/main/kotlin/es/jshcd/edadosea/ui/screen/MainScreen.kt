import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import es.jshcd.edadosea.R
import es.jshcd.edadosea.core.NUMBER_OF_BONES
import es.jshcd.edadosea.ui.NavigationButtons
import es.jshcd.edadosea.ui.PatientState
import es.jshcd.edadosea.ui.Sex
import es.jshcd.edadosea.ui.getBoneById
import es.jshcd.edadosea.ui.getDrawableIdByBone
import es.jshcd.edadosea.ui.getPossiblePatientSexs
import es.jshcd.edadosea.ui.getPossibleStadiosByBone

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

@Composable
fun BoneScreen(
    modifier: Modifier,
    state: PatientState,
    onShowFullScreenImage: () -> Unit
) {
    Column(
        modifier = modifier,
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
            TextField(
                modifier = Modifier.clickable(
                    onClick = {
                        expanded.value = !expanded.value
                    }
                ),
                value = state.values[state.selectedBone], //state.selectedSex.name,
                onValueChange = {

                },
                enabled = false
            )

            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { },

                ) {
                val items: List<String> = getPossibleStadiosByBone(state.selectedBone)
                items.forEach { s ->
                    DropdownMenuItem(
                        onClick = {
                            //selectedValue.value = s
                            state.values[state.selectedBone] = s
                            expanded.value = false
                        }
                    ) {
                        Text(text = s)
                    }
                }
            }
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

@Composable
fun SexScreen(
    modifier: Modifier,
    state: PatientState
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.indicate_patient_sex)
        )

        val expanded = remember { mutableStateOf(false) }
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
            items.forEachIndexed { index, s ->
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

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen(
        state = PatientState(),
        onActionButtonClick = {},
        onPreviousClick = {},
        onNextClick = {},
        onCalculateBoneAgeClick = {},
        onShowFullScreenImage = {}
    )
}