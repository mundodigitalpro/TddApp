package com.josejordan.tddapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class LoginIntegrationTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun `inicio de sesión exitoso`() {
        // Crear el mock usando Mockito
        val authService: AuthService = mock(AuthService::class.java)

        // Configurar el comportamiento del mock para que el método autenticar()
        // devuelva true cuando se le pasen los argumentos "usuario" y "contraseña123"
        `when`(authService.autenticar("usuario", "contraseña123")).thenReturn(true)

        // Inicializar el LoginViewModel con el mock de AuthService
        val loginViewModel = LoginViewModel(authService)

        // Ejecutar el método que queremos probar
        loginViewModel.iniciarSesion("usuario", "contraseña123")

        // Verificar que el resultado es el esperado
        assertEquals(true, loginViewModel.estadoInicioSesion.value)
    }
}

open class AuthService {

    open fun autenticar(usuario: String, contraseña: String): Boolean {
        return usuario == "usuarioValido" && contraseña == "contraseñaValida"
    }
}

class LoginViewModel(private val authService: AuthService) : ViewModel() {

    val estadoInicioSesion = MutableLiveData<Boolean>()

    fun iniciarSesion(usuario: String, contraseña: String) {
        val resultado = authService.autenticar(usuario, contraseña)
        estadoInicioSesion.value = resultado
    }
}