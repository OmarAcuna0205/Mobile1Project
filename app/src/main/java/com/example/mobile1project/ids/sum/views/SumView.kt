package com.example.mobile1project.ids.sum.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobile1project.ids.sum.viewmodels.SumViewModel
import com.example.mobile1project.R // Asegúrate de importar los recursos correctamente

@Composable
fun SumScreen(sumViewModel: SumViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally // Para centrar la imagen
    ) {
        // Imagen en la parte superior con forma circular
        Image(
            painter = painterResource(id = R.drawable.suma), // Asegúrate de tener esta imagen en tu carpeta drawable
            contentDescription = "Imagen representando la suma", // Descripción accesible de la imagen
            modifier = Modifier
                .size(300.dp) // Tamaño de la imagen
        )

        Spacer(modifier = Modifier.height(16.dp)) // Espacio después de la imagen

        // Campos de texto
        TextField(
            value = sumViewModel.number1,
            onValueChange = { sumViewModel.number1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = sumViewModel.number2,
            onValueChange = { sumViewModel.number2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { sumViewModel.calculateSum() },
            modifier = Modifier.fillMaxWidth() // Esto hace que el botón ocupe todo el ancho
        ) {
            Text("Sumar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Resultado: ${sumViewModel.result}", style = MaterialTheme.typography.titleLarge)
    }
}
