package com.example.mobile1project.ids.restaurant.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobile1project.ids.restaurant.viewmodels.RestaurantViewModel
import com.example.mobile1project.ids.restaurant.views.RestaurantDetailScreen
import com.example.mobile1project.ids.restaurant.views.RestaurantListScreen

sealed class Screen(val route: String) {
    object List : Screen("restaurant_list")
    object Detail : Screen("restaurant_detail")
}

@Composable
fun RestaurantNavGraph(
    viewModel: RestaurantViewModel,
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Screen.List.route) {
        composable(Screen.List.route) {
            RestaurantListScreen(viewModel = viewModel) { restaurant ->
                viewModel.selectRestaurant(restaurant)
                navController.navigate(Screen.Detail.route)
            }
        }
        composable(Screen.Detail.route) {
            val restaurant = viewModel.selectedRestaurant.value
            if (restaurant != null) {
                RestaurantDetailScreen(restaurant = restaurant)
            }
        }
    }
}
