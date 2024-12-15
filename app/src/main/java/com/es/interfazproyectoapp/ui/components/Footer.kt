package com.es.interfazproyectoapp.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.AddBox
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material.icons.sharp.Person
import androidx.compose.material3.BottomAppBarDefaults.containerColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.es.interfazproyectoapp.R

@Composable
fun Footer(navController: NavController) {
    NavigationBar(
        modifier = Modifier,
        containerColor = NavigationBarDefaults.containerColor,
        contentColor = MaterialTheme.colorScheme.contentColorFor(containerColor)
    ) {
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Sharp.Home,
                    contentDescription = "Go back",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(25.dp)
                )
            },
            selected = false,
            onClick = { navController.navigate("main") }
        )
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Sharp.Person,
                    contentDescription = "Go back",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(25.dp)
                )
            },
            selected = false,
            onClick = { navController.navigate("profile") }
        )
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Sharp.AddBox,
                    contentDescription = "Go back",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(25.dp)
                )
            },
            selected = false,
            onClick = { navController.navigate("addProduct") }
        )
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Sharp.Menu,
                    contentDescription = "Go back",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(25.dp)
                )
            },
            selected = false,
            onClick = { navController.navigate("options") }
        )
    }
}