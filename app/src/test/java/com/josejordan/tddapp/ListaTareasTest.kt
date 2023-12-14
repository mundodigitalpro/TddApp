package com.josejordan.tddapp

import junit.framework.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ListaTareas {
    private val tareas = mutableListOf<String>()
    private val tareasCompletadas = mutableListOf<String>()

    fun marcarComoCompletada(tarea: String) {
        if (tareas.contains(tarea)) {
            tareasCompletadas.add(tarea)
        }
    }

    fun esTareaCompletada(tarea: String): Boolean {
        return tareasCompletadas.contains(tarea)
    }

    fun añadirTarea(tarea: String) {
        tareas.add(tarea)
    }

    fun obtenerTareas(): List<String> {
        return tareas
    }

    fun eliminarTarea(tarea: String) {
        tareas.remove(tarea)
    }
}


class ListaTareasTest {

    @Test
    fun `añadir tarea a la lista`() {
        val listaTareas = ListaTareas()
        listaTareas.añadirTarea("Aprender Kotlin")
        assertTrue(listaTareas.obtenerTareas().contains("Aprender Kotlin"))
    }

    @Test
    fun `eliminar tarea de la lista`() {
        val listaTareas = ListaTareas()
        listaTareas.añadirTarea("Aprender Kotlin")
        listaTareas.eliminarTarea("Aprender Kotlin")
        assertFalse(listaTareas.obtenerTareas().contains("Aprender Kotlin"))
    }

    @Test
    fun `marcar tarea como completada`() {
        val listaTareas = ListaTareas()
        listaTareas.añadirTarea("Aprender Kotlin")
        listaTareas.marcarComoCompletada("Aprender Kotlin")
        assertTrue(listaTareas.esTareaCompletada("Aprender Kotlin"))
    }
}