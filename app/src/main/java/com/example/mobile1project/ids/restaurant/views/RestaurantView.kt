package com.example.mobile1project.ids.restaurant.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobile1project.ids.restaurant.models.Restaurant
import com.example.mobile1project.ids.restaurant.viewmodels.RestaurantViewModel
import com.example.mobile1project.R
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantListScreen(
    viewModel: RestaurantViewModel = viewModel(),
    onRestaurantClick: (Restaurant) -> Unit
) {
    val restaurants by viewModel.restaurants.collectAsState()
    val isRefreshing by viewModel.isRefreshing.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val errorMessage by viewModel.errorMessage.collectAsState()

    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isRefreshing)

    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.clearErrorMessage()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text("LISTA DE RESTAURANTES")
                    }
                }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = { viewModel.refreshRestaurants() }
        ) {
            LazyColumn(
                contentPadding = padding,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(16.dp)
            ) {
                items(restaurants) { restaurant ->
                    RestaurantCard(
                        restaurant = restaurant,
                        onClick = { onRestaurantClick(restaurant) }
                    )
                }
            }
        }
    }
}

@Composable
fun RestaurantCard(restaurant: Restaurant, onClick: () -> Unit) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column {
            Image(
                painter = painterResource(id = getDrawableId(restaurant.imgName)),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = restaurant.name,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(6.dp),
                            tonalElevation = 2.dp
                        ) {
                            Text(
                                text = restaurant.rating.toString(),
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Icon(
                            painter = painterResource(
                                if (restaurant.isFavorite) R.drawable.ic_favorite_filled
                                else R.drawable.ic_favorite_border
                            ),
                            contentDescription = "Favorito",
                            tint = Color.Black,
                            modifier = Modifier.size(23.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(text = "MX ${restaurant.fee} Delivery Fee · ${restaurant.delivery}")
            }
        }
    }
}

@Composable
fun getDrawableId(imageName: String): Int {
    val context = LocalContext.current
    val nameWithoutExtension = imageName.substringBeforeLast('.').lowercase()
    val resId = context.resources.getIdentifier(nameWithoutExtension, "drawable", context.packageName)
    return if (resId != 0) resId else android.R.drawable.ic_menu_report_image
}