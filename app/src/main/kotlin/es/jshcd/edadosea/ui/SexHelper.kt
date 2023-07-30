package es.jshcd.edadosea.ui

private const val MONTHS_OF_THE_YEAR = 12

fun getPossiblePatientSexs(): List<String> {
    return listOf(Sex.MALE.name, Sex.FEMALE.name)
}

fun calculateNumberOfYearsFromAge(patientAge: Float): Int {
    return (patientAge / 1).toInt()
}

fun calculateNumberOfMonthsFromAge(patientAge: Float): Int {
    return (patientAge % 1 * MONTHS_OF_THE_YEAR).toInt()
}