package com.es.interfazproyectoapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.es.interfazproyectoapp.ui.components.DefaultAppBar
import com.es.interfazproyectoapp.ui.components.Footer

@Composable
fun OptionsScreen(navController: NavController) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Button(onClick = {  }, modifier = Modifier.fillMaxWidth()) {
                    Text("Settings")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {  }, modifier = Modifier.fillMaxWidth()) {
                    Text("Notifications")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { navController.navigate("welcome") }, modifier = Modifier.fillMaxWidth()) {
                    Text("Logout")
                }
            }
        },
        bottomBar = {
            Footer(navController)
        },
        topBar = {
            DefaultAppBar(
                "Opciones",
                navController
            )
        }
    )
}