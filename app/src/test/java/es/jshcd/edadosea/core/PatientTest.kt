package es.jshcd.edadosea.core

import org.junit.Assert.assertThrows
import org.junit.Test

internal class PatientTest {
    private lateinit var patient: Patient

    @Test
    fun test_calculateBoneAge_Throws_WrongEstadioException_last_lower_than_zero() {
        patient = Patient(
            mSex = 0,
            aEstadios = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1).toIntArray()
        )
        assertThrows(Patient.WrongEstadioException::class.java) {
            patient.calculateBoneAge()
        }
    }

    @Test
    fun test_calculateBoneAge_Throws_WrongEstadioException_second_greater_than_seven() {
        patient = Patient(
            mSex = 0,
            aEstadios = arrayOf(8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8).toIntArray()
        )
        assertThrows(Patient.WrongEstadioException::class.java) {
            patient.calculateBoneAge()
        }
    }

    @Test
    fun test_calculateBoneAge_Throws_WrongEstadioException_last_greater_than_eight() {
        patient = Patient(
            mSex = 0,
            aEstadios = arrayOf(8, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9).toIntArray()
        )
        assertThrows(Patient.WrongEstadioException::class.java) {
            patient.calculateBoneAge()
        }
    }

    @Test
    fun test_calculateBoneAge_Throws_PatientIsAdultException() {
        patient = Patient(
            mSex = 0,
            aEstadios = arrayOf(8, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8).toIntArray()
        )
        assertThrows(Patient.PatientIsAdultException::class.java) {
            patient.calculateBoneAge()
        }
    }

    @Test
    fun test_calculateBoneAge_NegativeSex_Throws_InvalidPatientSexException() {
        patient = Patient(
            mSex = -1,
            aEstadios = arrayOf(8, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8).toIntArray()
        )
        assertThrows(Patient.InvalidPatientSexException::class.java) {
            patient.calculateBoneAge()
        }
    }

    @Test
    fun test_calculateBoneAge_SexGreaterThanOne_Throws_InvalidPatientSexException() {
        patient = Patient(
            mSex = 2,
            aEstadios = arrayOf(8, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8).toIntArray()
        )
        assertThrows(Patient.InvalidPatientSexException::class.java) {
            patient.calculateBoneAge()
        }
    }
}