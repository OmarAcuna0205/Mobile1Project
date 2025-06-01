package com.example.mobile1project.ids.restaurant.views

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile1project.ids.restaurant.models.Restaurant
import com.example.mobile1project.ids.restaurant.views.getDrawableId
import androidx.compose.runtime.*
import com.google.maps.android.compose.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

@Composable
fun RestaurantDetailScreen(restaurant: Restaurant) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen principal
        Image(
            painter = painterResource(id = getDrawableId(restaurant.imgName)),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = restaurant.name,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = "Horario: ${restaurant.schedule}",
            fontSize = 16.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(24.dp))

        val restaurantLatLng = LatLng(restaurant.latitude.toDouble(), restaurant.longitude.toDouble())
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(restaurantLatLng, 15f)
        }

        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(position = restaurantLatLng),
                title = restaurant.name,
                snippet = "Ubicación del restaurante"
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${restaurant.phone}"))
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = "Llamar",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Llamar", color = Color.White)
            }

            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(restaurant.webSite))
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Icon(
                    imageVector = Icons.Filled.Public,
                    contentDescription = "Sitio Web",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sitio Web", color = Color.White)
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}
