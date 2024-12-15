package com.es.interfazproyectoapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.es.interfazproyectoapp.ui.components.Header
import com.es.interfazproyectoapp.ui.components.PasswordVisibilityToggleIcon
import com.es.interfazproyectoapp.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen(navController: NavController, viewModel: RegisterViewModel = viewModel()) {
    val email by viewModel.email.observeAsState("")
    val password by viewModel.password.observeAsState("")
    val confirmPassword by viewModel.confirmPassword.observeAsState("")
    val errorMessage by viewModel.errorMessage.observeAsState("")
    val showPassword by viewModel.showPassword.observeAsState(false)
    val isRegisterEnabled by viewModel.isRegisterEnabled.observeAsState(false)

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header(navController)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("REGISTRARSE", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { viewModel.onRegisterChange(it, password, confirmPassword) },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = password,
                onValueChange = { viewModel.onRegisterChange(email, it, confirmPassword) },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    PasswordVisibilityToggleIcon(
                        showPassword = showPassword,
                        onTogglePasswordVisibility = { viewModel.togglePasswordVisibility() })
                }
            )

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { viewModel.onRegisterChange(email, password, it) },
                label = { Text("Confirmar Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
            )

            if (errorMessage.isNotEmpty()) {
                Text(errorMessage, color = Color.Red, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { if (isRegisterEnabled) navController.navigate("login") },
                modifier = Modifier.fillMaxWidth(),
                enabled = isRegisterEnabled,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("REGISTRARSE", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Normal)
            }
        }
    }
}