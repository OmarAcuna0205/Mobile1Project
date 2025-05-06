package com.example.mobile1project.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenNavigation(val route: String, val label: String, val icon: ImageVector) {
    object Ids : ScreenNavigation("IdsRoute", "Inicio", Icons.Default.Home)
    object FirstPartial : ScreenNavigation("FirstPartialRoute", "Parcial 1", Icons.Default.FindInPage)
    object SecondPartial : ScreenNavigation("SecondPartialRoute", "Parcial 2", Icons.Default.FindInPage)
    object ThirdPartial : ScreenNavigation("ThirdPartialRoute", "Parcial 3", Icons.Default.FindInPage)

    object Imc : ScreenNavigation("ImcRoute", "IMC", Icons.Default.Add)
    object Sum : ScreenNavigation("SumRoute", "Suma", Icons.Default.Add)
    object Temp : ScreenNavigation("TempRoute", "Temperatura", Icons.Default.Add)
    object Students : ScreenNavigation("StudentListRoute", "Lista Estudiantes", Icons.Default.Add)

}

