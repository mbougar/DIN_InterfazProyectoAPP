package com.es.interfazproyectoapp.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _email = MutableLiveData("")
    val email: LiveData<String> get() = _email

    private val _password = MutableLiveData("")
    val password: LiveData<String> get() = _password

    private val _isLoginEnabled = MutableLiveData(false)
    val isLoginEnabled: LiveData<Boolean> get() = _isLoginEnabled

    private val _showPassword = MutableLiveData(false)
    val showPassword: LiveData<Boolean> get() = _showPassword

    fun onLoginChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnabled.value = isLoginValid(email, password)
    }

    fun togglePasswordVisibility() {
        _showPassword.value = _showPassword.value != true
    }

    private fun isLoginValid(email: String, password: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6
    }
}