package com.example.mobile1project.thirdpartial

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mobile1project.navigation.ScreenNavigation

@Composable
fun ThirdPartialView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Texto centrado
        Text(
            text = "Tercer Parcial",
            style = MaterialTheme.typography.headlineSmall.copy(fontSize = 24.sp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(ScreenNavigation.Students.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF81C784))
        ) {
            Text("MOSTRAR ESTUDIANTES", style = MaterialTheme.typography.bodyLarge)
        }

        Button(
            onClick = { navController.navigate(ScreenNavigation.Locations.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF81C784))
        ) {
            Text("MOSTRAR UBICACIONES", style = MaterialTheme.typography.bodyLarge)
        }
        Button(
            onClick = { navController.navigate(ScreenNavigation.Itits.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF81C784))
        ) {
            Text("MOSTRAR ITITS", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

