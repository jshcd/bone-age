package es.jshcd.edadosea.ui.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import es.jshcd.edadosea.R
import es.jshcd.edadosea.ui.calculateNumberOfMonthsFromAge
import es.jshcd.edadosea.ui.calculateNumberOfYearsFromAge

@Composable
fun AgeComposable(
    patientAge: Float
) {
    Text(
        text = stringResource(
            id = R.string.patient_bone_age_is,
            calculateNumberOfYearsFromAge(patientAge),
            calculateNumberOfMonthsFromAge(patientAge)
        )
    )
}