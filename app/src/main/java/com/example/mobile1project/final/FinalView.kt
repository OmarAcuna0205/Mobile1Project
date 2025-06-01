package com.example.mobile1project.final

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
fun FinalView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Proyecto Final",
            style = MaterialTheme.typography.headlineSmall.copy(fontSize = 24.sp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(ScreenNavigation.Restaurants.route) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF81C784)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("MOSTRAR RESTAURANTES", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

