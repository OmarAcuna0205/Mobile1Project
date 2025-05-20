package com.example.mobile1project.ids.itit.repository

import com.example.mobile1project.ids.itit.models.Student
import com.example.mobile1project.ids.itit.network.ItitApiService

class ItitRepository(private val apiService: ItitApiService) {
    suspend fun fetchStudents(): List<Student> {
        return apiService.getStudents()
    }
}