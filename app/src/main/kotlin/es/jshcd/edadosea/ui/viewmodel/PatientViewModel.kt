package es.jshcd.edadosea.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.jshcd.edadosea.core.Patient
import es.jshcd.edadosea.ui.PatientState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PatientViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(PatientState())
    val uiState: StateFlow<PatientState> = _uiState.asStateFlow()

    fun onNext() {
        val nextId = uiState.value.selectedBone + 1
        viewModelScope.launch {
            _uiState.emit(
                uiState.value.copy(
                    selectedBone = nextId
                )
            )
        }
    }

    fun onPrevious() {
        val previousId = uiState.value.selectedBone - 1
        viewModelScope.launch {
            _uiState.emit(
                uiState.value.copy(
                    selectedBone = previousId
                )
            )
        }
    }

    @Throws(
        Patient.WrongEstadioException::class,
        Patient.InvalidPatientSexException::class,
        Patient.PatientIsAdultException::class
    )
    fun onCalculateBoneAge(): Float {
        val patient = Patient(
            mSex = uiState.value.selectedSex.ordinal,
            aEstadios = uiState.value.values.map {
                when(it) {
                    "A" -> 0
                    "B" -> 1
                    "C" -> 2
                    "D" -> 3
                    "E" -> 4
                    "F" -> 5
                    "G" -> 6
                    "H" -> 7
                    "I" -> 8
                    else -> -1
                }
            }.toIntArray()
        )
        return patient.calculateBoneAge()
    }

    fun resetUiState() {
        viewModelScope.launch {
            _uiState.emit(
                PatientState()
            )
        }
    }
}