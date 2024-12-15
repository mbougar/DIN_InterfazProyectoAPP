package com.es.interfazproyectoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.es.interfazproyectoapp.R
import com.es.interfazproyectoapp.ui.components.Header
import com.es.interfazproyectoapp.ui.components.PasswordVisibilityToggleIcon
import com.es.interfazproyectoapp.viewmodel.LoginViewModel

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = viewModel()) {
    val email by viewModel.email.observeAsState("")
    val password by viewModel.password.observeAsState("")
    val isLoginEnabled by viewModel.isLoginEnabled.observeAsState(false)
    val showPassword by viewModel.showPassword.observeAsState(false)

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
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text("INICIO DE SESIÓN", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Introduce tus credenciales para iniciar sesión")
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { viewModel.onLoginChange(it, password) },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password,
                onValueChange = { viewModel.onLoginChange(email, it) },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    PasswordVisibilityToggleIcon(
                        showPassword = showPassword,
                        onTogglePasswordVisibility = { viewModel.togglePasswordVisibility() })
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { if (isLoginEnabled) navController.navigate("main") },
                modifier = Modifier.fillMaxWidth(),
                enabled = isLoginEnabled,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("INICIAR SESIÓN", fontSize = 16.sp, fontWeight = FontWeight.Normal)
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextButton(onClick = { }) {
                    Text("¿Olvidaste tu contraseña?", color = Color.Gray)
                }
            }
        }
    }
}