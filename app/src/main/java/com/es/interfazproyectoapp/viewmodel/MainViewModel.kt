package com.es.interfazproyectoapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import com.es.interfazproyectoapp.R
import com.es.interfazproyectoapp.model.Producto

class MainViewModel : ViewModel() {
    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    private val _searchTextState: MutableState<String> =
        mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }

    val productos = mutableListOf<Producto>(
        Producto(
            nombre = "Manzana",
            imagen = R.drawable.fruta,
            precio = 2.40
        ),
        Producto(
            nombre = "Laptop",
            imagen = R.drawable.electronico,
            precio = 850.99
        ),
        Producto(
            nombre = "Silla",
            imagen = R.drawable.objeto,
            precio = 45.50
        ),
        Producto(
            nombre = "Plátano",
            imagen = R.drawable.fruta,
            precio = 1.20
        ),
        Producto(
            nombre = "Teléfono",
            imagen = R.drawable.electronico,
            precio = 699.99
        ),
        Producto(
            nombre = "Mesa",
            imagen = R.drawable.objeto,
            precio = 120.75
        ),
        Producto(
            nombre = "Naranja",
            imagen = R.drawable.fruta,
            precio = 3.10
        ),
        Producto(
            nombre = "Auriculares",
            imagen = R.drawable.electronico,
            precio = 59.99
        ),
        Producto(
            nombre = "Reloj",
            imagen = R.drawable.objeto,
            precio = 35.80
        ),
        Producto(
            nombre = "Pera",
            imagen = R.drawable.fruta,
            precio = 2.25
        ),
        Producto(
            nombre = "Cámara",
            imagen = R.drawable.electronico,
            precio = 499.99
        ),
        Producto(
            nombre = "Lámpara",
            imagen = R.drawable.objeto,
            precio = 23.40
        )
    )
}