package es.jshcd.edadosea.ui

data class PatientState(
    val selectedBone: Int = 0,
    var selectedSex: Sex = Sex.MALE,
    val values: MutableList<String> = MutableList(13) { "A" }
)

enum class Sex { MALE, FEMALE }