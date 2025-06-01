package com.example.mobile1project.ids.restaurant.repository

import com.example.mobile1project.ids.restaurant.models.Restaurant
import com.example.mobile1project.ids.restaurant.network.RestaurantApiService

class RestaurantRepository(private val apiService: RestaurantApiService) {
    suspend fun fetchRestaurants(): List<Restaurant> {
        return apiService.getRestaurants()
    }
}