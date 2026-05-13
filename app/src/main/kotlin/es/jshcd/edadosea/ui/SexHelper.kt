package es.jshcd.edadosea.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import es.jshcd.edadosea.R

private const val MONTHS_OF_THE_YEAR = 12

@Composable
fun Sex.getLabel() = when (this) {
    Sex.MALE -> stringResource(id = R.string.sex_male)
    Sex.FEMALE -> stringResource(id = R.string.sex_female)
}

fun calculateNumberOfYearsFromAge(patientAge: Float): Int {
    return (patientAge / 1).toInt()
}

fun calculateNumberOfMonthsFromAge(patientAge: Float): Int {
    return (patientAge % 1 * MONTHS_OF_THE_YEAR).toInt()
}