package com.example.mobile1project.ids.students.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel // 👈 Asegúrate de importar esto
import com.example.mobile1project.ids.students.viewmodels.StudentViewModel

@Composable
fun StudentListScreen() {
    val viewModel: StudentViewModel = viewModel()
    StudentListScreen(viewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentListScreen(viewModel: StudentViewModel) {
    val students by viewModel.students.collectAsState()

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("Lista de Estudiantes") }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            items(students) { student ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Text(
                        text = student.name,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}


