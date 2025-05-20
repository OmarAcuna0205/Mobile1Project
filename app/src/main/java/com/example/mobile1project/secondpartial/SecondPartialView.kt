package com.example.mobile1project.secondpartial

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mobile1project.navigation.ScreenNavigation

@Composable
fun SecondPartialView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // <-- esta línea centra todo horizontalmente
    ) {
        Text(
            text = "Segundo Parcial",
            style = MaterialTheme.typography.headlineSmall.copy(fontSize = 24.sp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(ScreenNavigation.Sum.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722))
        ) {
            Text("CALCULAR SUMA", style = MaterialTheme.typography.bodyLarge)
        }

        Button(
            onClick = { navController.navigate(ScreenNavigation.Imc.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722))
        ) {
            Text("CALCULAR IMC", style = MaterialTheme.typography.bodyLarge)
        }

        Button(
            onClick = { navController.navigate(ScreenNavigation.Temp.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722))
        ) {
            Text("CALCULAR TEMPERATURA", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
