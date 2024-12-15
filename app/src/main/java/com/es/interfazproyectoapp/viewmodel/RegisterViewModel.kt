package com.es.interfazproyectoapp.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    private val _email = MutableLiveData("")
    val email: LiveData<String> get() = _email

    private val _password = MutableLiveData("")
    val password: LiveData<String> get() = _password

    private val _confirmPassword = MutableLiveData("")
    val confirmPassword: LiveData<String> get() = _confirmPassword

    private val _errorMessage = MutableLiveData("")
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _isRegisterEnabled = MutableLiveData(false)
    val isRegisterEnabled: LiveData<Boolean> get() = _isRegisterEnabled

    private val _showPassword = MutableLiveData(false)
    val showPassword: LiveData<Boolean> get() = _showPassword

    fun onRegisterChange(email: String, password: String, confirmPassword: String) {
        _email.value = email
        _password.value = password
        _confirmPassword.value = confirmPassword

        validateFields(email, password, confirmPassword)
    }

    private fun validateFields(email: String, password: String, confirmPassword: String) {
        when {
            email.isBlank() -> _errorMessage.value = "El correo no puede estar vacío"
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> _errorMessage.value = "El correo no es válido"
            password.length < 6 -> _errorMessage.value = "La contraseña debe tener al menos 6 caracteres"
            password != confirmPassword -> _errorMessage.value = "Las contraseñas no coinciden"
            else -> {
                _errorMessage.value = ""
                _isRegisterEnabled.value = true
                return
            }
        }
        _isRegisterEnabled.value = false
    }

    fun togglePasswordVisibility() {
        _showPassword.value = _showPassword.value != true
    }
}