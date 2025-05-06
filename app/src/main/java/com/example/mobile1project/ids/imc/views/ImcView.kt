package com.example.mobile1project.ids.imc.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobile1project.R
import com.example.mobile1project.ids.imc.viewmodels.IMCViewModel
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.res.painterResource

@Composable
fun IMCScreen(imcViewModel: IMCViewModel = viewModel()) {
    // Obtener el contexto local
    val resources = LocalContext.current.resources

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally // Centrado de la imagen
    ) {
        // Imagen en la parte superior con forma circular
        Image(
            painter = painterResource(id = R.drawable.imc), // Asegúrate de tener esta imagen en tu carpeta drawable
            contentDescription = "Imagen representando la suma", // Descripción accesible de la imagen
            modifier = Modifier
                .size(300.dp) // Tamaño de la imagen
        )

        Spacer(modifier = Modifier.height(16.dp)) // Espacio después de la imagen

        // Campo de texto para el peso
        TextField(
            value = imcViewModel.weight,
            onValueChange = { imcViewModel.weight = it },
            label = { Text(stringResource(R.string.weight_label)) },
            modifier = Modifier.fillMaxWidth(),
            isError = imcViewModel.errorMessage.isNotEmpty() // Muestra error si hay mensaje
        )

        Spacer(modifier = Modifier.height(8.dp)) // Espacio entre campos

        // Campo de texto para la altura
        TextField(
            value = imcViewModel.height,
            onValueChange = { imcViewModel.height = it },
            label = { Text(stringResource(R.string.height_label)) },
            modifier = Modifier.fillMaxWidth(),
            isError = imcViewModel.errorMessage.isNotEmpty() // Muestra error si hay mensaje
        )

        // Mostrar mensaje de error si existe
        if (imcViewModel.errorMessage.isNotEmpty()) {
            Text(
                text = imcViewModel.errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // Espacio antes del botón

        // Botón para calcular IMC
        Button(
            onClick = { imcViewModel.calculateBMI(resources) },
            modifier = Modifier.fillMaxWidth() // El botón ocupa todo el ancho
        ) {
            Text(text = stringResource(R.string.calculate_button)) // Botón de cálculo
        }

        Spacer(modifier = Modifier.height(16.dp)) // Espacio después del botón

        // Mostrar el resultado del IMC si está disponible
        if (imcViewModel.bmiResult.isNotEmpty()) {
            Text(
                text = imcViewModel.bmiResult,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        // Mostrar la evaluación si está disponible
        if (imcViewModel.evaluation.isNotEmpty()) {
            Text(
                text = imcViewModel.evaluation,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
