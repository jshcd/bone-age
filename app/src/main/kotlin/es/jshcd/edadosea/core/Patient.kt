package es.jshcd.edadosea.core

class Patient(
    private var mSex: Int = 0,
    private var aEstadios: IntArray
) {

    /**
     * Calcula la edad ósea como un valor en coma flotante.
     * @param aEstadios An array with the selected values related to the bones (A, B, C, ...).
     * @return The bone age as a floating point value (in years).
     */
    @Throws(
        WrongEstadioException::class,
        InvalidPatientSexException::class,
        PatientIsAdultException::class
    )
    fun calculateBoneAge(): Float {
        if (isThereSomeErrorInEstadios(aEstadios)) {
            throw WrongEstadioException()
        } else {
            // Continue if all fields are filled
            return when (mSex) {
                MALE -> calculateGenericBoneAge(
                    aEstadios,
                    RUS_TABLE_MALE,
                    POINTS_TABLE_MALE
                )

                FEMALE -> calculateGenericBoneAge(
                    aEstadios,
                    RUS_TABLE_FEMALE,
                    POINTS_TABLE_FEMALE
                )

                else -> throw InvalidPatientSexException()
            }
        }
    }

    private fun isThereSomeErrorInEstadios(aEstadios: IntArray): Boolean {
        aEstadios.forEachIndexed { index, estadio ->
            if (estadio < 0) return true
            if (index == 1) {
                if (estadio > 7) return true
            } else {
                if (estadio > 8) return true
            }
        }
        return false
    }

    /**
     * Calculates the bone age for male and female patients.
     * @param aEstadios An array with the selected values related to the bones (A, B, C, ...).
     * @param aTableRUS A RUS table with constants for male or female, depending on the patient sex.
     * @param aPointsTable A points table with constants for male of female, depending of the patient sex.
     * @return The bone age as a floating point value (in years).
     */
    @Throws(PatientIsAdultException::class)
    private fun calculateGenericBoneAge(
        aEstadios: IntArray, aTableRUS: Array<IntArray>,
        aPointsTable: IntArray
    ): Float {
        var lBoneAge: Float
        var lPoints = 0
        var lAge = 0
        for (i in 0..12) {
            lPoints += aTableRUS[i][aEstadios[i]]
        }

        if (lPoints >= 1000) {
            throw PatientIsAdultException()
        } else {
            while (aPointsTable[lAge] < lPoints) {
                lAge++
            }
            lBoneAge = (lAge + 10).toFloat()
            lBoneAge /= 10f
        }
        return lBoneAge
    }

    class WrongEstadioException : Exception()

    class InvalidPatientSexException : Exception()

    class PatientIsAdultException : Exception()
}