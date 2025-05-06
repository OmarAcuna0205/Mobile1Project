package com.example.mobile1project.ids

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mobile1project.navigation.ScreenNavigation

@Composable
fun IdsView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp) // Espaciado mayor entre botones
    ) {

        // Botón de suma con tamaño mediano y color verde
        Button(
            onClick = { navController.navigate(ScreenNavigation.Sum.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), // Tamaño mediano
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722)) // Color verde
        ) {
            Text("SUM", style = MaterialTheme.typography.bodyLarge)
        }

        // Botón IMC con un tamaño grande y color personalizado
        Button(
            onClick = { navController.navigate(ScreenNavigation.Imc.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), // Tamaño más grande
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722)) // Color azul
        ) {
            Text("IMC", style = MaterialTheme.typography.bodyLarge)
        }

        // Botón de temperatura con tamaño pequeño y color naranja
        Button(
            onClick = { navController.navigate(ScreenNavigation.Temp.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), // Tamaño pequeño
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722)) // Color naranja
        ) {
            Text("TEMP", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
