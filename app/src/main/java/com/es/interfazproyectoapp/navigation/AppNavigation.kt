package com.es.interfazproyectoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.es.interfazproyectoapp.ui.screens.WelcomeScreen
import com.es.interfazproyectoapp.ui.screens.MainScreen
import com.es.interfazproyectoapp.ui.screens.AddProductScreen
import com.es.interfazproyectoapp.ui.screens.ProfileScreen
import com.es.interfazproyectoapp.ui.screens.OptionsScreen
import com.es.interfazproyectoapp.ui.screens.LoginScreen
import com.es.interfazproyectoapp.ui.screens.RegisterScreen


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("main") { MainScreen(navController) }
        composable("addProduct") { AddProductScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("options") { OptionsScreen(navController) }
    }
}