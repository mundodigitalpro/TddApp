package com.josejordan.tddapp

import org.junit.Assert.*
import org.junit.Test

class AutenticacionTest {

    @Test
    fun `inicio de sesión con credenciales correctas`() {
        val sistemaAuth = SistemaAutenticacion()
        assertTrue(sistemaAuth.iniciarSesion("usuario", "contraseña123"))
    }

    @Test
    fun `inicio de sesión con credenciales incorrectas`() {
        val sistemaAuth = SistemaAutenticacion()
        assertFalse(sistemaAuth.iniciarSesion("usuario", "contraseñaIncorrecta"))
    }

}

class SistemaAutenticacion {

    fun iniciarSesion(usuario: String, contraseña: String): Boolean {
        // Simulando una validación de credenciales
        return usuario == "usuario" && contraseña == "contraseña123"
    }
}
