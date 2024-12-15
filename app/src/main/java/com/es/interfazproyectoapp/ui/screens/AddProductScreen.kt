package com.es.interfazproyectoapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.es.interfazproyectoapp.ui.components.DefaultAppBar
import com.es.interfazproyectoapp.ui.components.Footer
import com.es.interfazproyectoapp.viewmodel.MainViewModel

@Composable
fun AddProductScreen(navController: NavController, viewModel: MainViewModel = MainViewModel()) {
    val productName = remember { mutableStateOf("") }
    val productDescription = remember { mutableStateOf("") }
    val searchWidgetState by viewModel.searchWidgetState
    val searchTextState by viewModel.searchTextState

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
                OutlinedTextField(
                    value = productName.value,
                    onValueChange = { productName.value = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Product Name") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = productDescription.value,
                    onValueChange = { productDescription.value = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Product Description") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {  },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Add Product")
                }
            }
        },
        bottomBar = {
            Footer(navController)
        },
        topBar = {
            DefaultAppBar(
                "Añadir Producto",
                navController
            )
        }
    )
}