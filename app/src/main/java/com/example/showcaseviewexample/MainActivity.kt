package com.example.showcaseviewexample

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

   /* private lateinit var showcaseView: ShowCaseView // Asegúrate de que sea el nombre correcto
    var target: View? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun initShowCase(){

        /*ShowCaseView(this)
        showcaseView = ShowCaseView(this).apply {
            setTarget(target!!)
            setTitle("Este es un ejemplo")
            setDescription("Descripción del componente a mostrar")
        }

        // Agregar el ShowcaseView a la vista principal
        //val mainShow = (findViewById<View>(android.R.id.content) as ViewGroup).addView(showcaseView)

        // Manejar el toque para ocultar el ShowcaseView
        showcaseView.setOnClickListener {
            (findViewById<View>(android.R.id.content) as ViewGroup).removeView(showcaseView)
        }*/
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        /*if (hasFocus){
            val location = IntArray(2)
            target?.getLocationOnScreen(location)
            Log.d("TAG","COORDENADAS => \n X = ${target?.x}, Y = ${target?.y}")
            initShowCase()
        }*/
    }
}