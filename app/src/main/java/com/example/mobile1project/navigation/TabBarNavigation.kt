package com.example.mobile1project.navigation

import android.media.MediaRouter2.ScanRequest
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.mobile1project.final.FinalView
import com.example.mobile1project.ids.IdsView
import com.example.mobile1project.ids.imc.views.IMCScreen
import com.example.mobile1project.firstpartial.FirstPartialView
import com.example.mobile1project.ids.itit.views.ItitListScreen
import com.example.mobile1project.ids.location.views.LocationListScreen
import com.example.mobile1project.ids.restaurant.navigation.RestaurantNavGraph
import com.example.mobile1project.ids.students.views.StudentListScreen
import com.example.mobile1project.ids.sum.views.SumScreen
import com.example.mobile1project.ids.temps.views.TempScreen
import com.example.mobile1project.secondpartial.SecondPartialView
import com.example.mobile1project.thirdpartial.ThirdPartialView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobile1project.ids.restaurant.viewmodels.RestaurantViewModel


@Composable
fun TabBarNavigationView(navController: NavHostController = rememberNavController()) {
    val items = listOf(
        // ScreenNavigation.Ids,
        ScreenNavigation.FirstPartial,
        ScreenNavigation.SecondPartial,
        ScreenNavigation.ThirdPartial,
        ScreenNavigation.Final
    )
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = screen.label) },
                        label = { Text(screen.label) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ScreenNavigation.FirstPartial.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(ScreenNavigation.Ids.route) { IdsView(navController) }
            composable(ScreenNavigation.FirstPartial.route) { FirstPartialView() }
            composable(ScreenNavigation.SecondPartial.route) { SecondPartialView(navController) }
            composable(ScreenNavigation.ThirdPartial.route) { ThirdPartialView(navController) }
            composable(ScreenNavigation.Final.route) {FinalView(navController) }
            composable(ScreenNavigation.Imc.route) { IMCScreen() }
            composable(ScreenNavigation.Sum.route) { SumScreen() }
            composable(ScreenNavigation.Temp.route) { TempScreen() }
            composable(ScreenNavigation.Students.route) { StudentListScreen() }
            composable(ScreenNavigation.Locations.route) { LocationListScreen() }
            composable(ScreenNavigation.Itits.route) { ItitListScreen() }
            composable(ScreenNavigation.Restaurants.route) {
                val restaurantViewModel: RestaurantViewModel = viewModel()
                RestaurantNavGraph(viewModel = restaurantViewModel)
            }
        }
    }
}