package com.juanfra.listviewgridviewadaptadorsimple

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/*
Autor: Juan Francisco Sánchez González
Fecha: 20/10/2024
Clase: Actividad donde se utiliza un adaptador simple para asignar las opciones a un control ListView
y a un GridView. Se implementan sus manejadores de eventos para controlar el click en sus elementos.
*/

class MainActivity : AppCompatActivity() {

    // Tipos de listados a utilizar
    lateinit var listadoListView: ListView
    lateinit var rejillaGridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Array de los datos para los elementos de los listados
        val datos: Array<String> = arrayOf("Elemento1", "Elemento2", "Elemento3", "Elemento4")

        initListView(datos)
        initGridView(datos)
    }

    // Instanciamos el objeto, creamos el adaptador simple que nos permita rellenar la lista
    // y asociamos el adaptador a la lista. Por último, se implementa su listener para
    // controlar el click en sus elementos.
    private fun initListView(datos: Array<String>) {
        listadoListView = findViewById(R.id.ListView)
        val adaptador: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, datos)
        listadoListView.adapter = adaptador
        listadoListView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, datos[position], Toast.LENGTH_SHORT).show()
        }
    }

    // Instanciamos el objeto, creamos el adaptador simple que nos permita rellenar la lista
    // y asociamos el adaptador a la rejilla. Por último, se implementa su listener para
    // controlar el click en sus elementos.
    private fun initGridView(datos: Array<String>) {
        rejillaGridView = findViewById(R.id.GridView)
        val adaptador: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, datos)
        rejillaGridView.adapter = adaptador
        rejillaGridView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, datos[position], Toast.LENGTH_SHORT).show()
        }
    }
}