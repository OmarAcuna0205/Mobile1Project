package com.example.mobile1project.ids.itit.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile1project.ids.itit.models.Student
import com.example.mobile1project.ids.itit.network.ItitApiService
import com.example.mobile1project.ids.itit.repository.ItitRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

class ItitViewModel : ViewModel() {

    private val apiService = ItitApiService.create()
    private val repository = ItitRepository(apiService)

    private val _students = MutableStateFlow<List<Student>>(emptyList())
    val students: StateFlow<List<Student>> = _students.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    init {
        loadStudents()
    }

    private fun loadStudents() {
        viewModelScope.launch {
            try {
                _students.value = repository.fetchStudents()
            } catch (e: UnknownHostException) {
                _errorMessage.value = "Sin conexión a Internet"
            } catch (e: HttpException) {
                when (e.code()) {
                    404 -> _errorMessage.value = "Error 404: Recurso no encontrado"
                    500 -> _errorMessage.value = "Error 500: Error del servidor"
                    else -> _errorMessage.value = "Error de red: ${e.code()}"
                }
            } catch (e: IOException) {
                _errorMessage.value = "Error de entrada/salida: ${e.message}"
            } catch (e: Exception) {
                _errorMessage.value = "Error inesperado: ${e.localizedMessage}"
            }
        }
    }

    fun clearErrorMessage() {
        _errorMessage.value = null
    }
}
