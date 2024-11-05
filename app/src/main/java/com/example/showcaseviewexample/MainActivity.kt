package com.example.showcaseviewexample

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig

class MainActivity : AppCompatActivity() {

    /* private lateinit var showcaseView: ShowCaseView // Asegúrate de que sea el nombre correcto
    var target: View? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val resaltado = findViewById<ImageView>(R.id.iv_one)
        val overlay = findViewById<HighlightOverlayView>(R.id.overlay_view)
        val image = findViewById<ImageView>(R.id.imageOne)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //CIRCULO
        resaltado.post {
            val location = IntArray(2)
            resaltado.getLocationInWindow(location)
            val centerX = location[0] + resaltado.width / 2f
            val centerY = location[1] + resaltado.height / 2f

            overlay.setHighlightCircleArea(centerX, centerY, resaltado.width * 0.6f)
        }
        //RECTANGULO
        image.post {
            val location = IntArray(2)
            image.getLocationInWindow(location)
            val left = location[0].toFloat()
            val top = location[1].toFloat()
            val right = left + image.width
            val bottom = top + image.height

            overlay.setHighlightRectangleArea(left, top, right, bottom)
        }

//        initShowCase()

    }

    private fun initShowCase() {

        val target = findViewById<View>(R.id.cv_five)
        val element1 = findViewById<View>(R.id.iv_one)
        val element2 = findViewById<View>(R.id.cv_two)
        val element3 = findViewById<View>(R.id.ayuda)

        val targets = arrayOf(element1,element2,element3)

        MaterialShowcaseView.Builder(this)
            .setMaskColour(resources.getColor(R.color.transparent)) //Color de fondo Aqui se mostraria el color transparente
            .setTarget(target)
            .setDismissTextColor(resources.getColor(R.color.black))
            //.setContentText("This is some amazing feature you should know about")
            // optional but starting animations immediately in onCreate can make them choppy
            //.singleUse("Material show view Case") // provide a unique ID used to ensure it is only shown once
            .show()


        val config = ShowcaseConfig().apply {
            dismissTextColor = resources.getColor(R.color.black)
        }


        val sequence = MaterialShowcaseSequence(this).apply {
            setConfig(config)

            addSequenceItem(targets[0], "Operaciones \nLas operaciones que haces en sucursal tambien puedes hacerlas desde la App ", "Continuar")
            addSequenceItem(targets[1], "Ayuda \nAqui encuentras las preguntas frecuentes", "Continuar")
            addSequenceItem(targets[2], "Historias \nEncuentra contenido de interes para tus finanzas", "Aceptar")
            start()

        }

    }
}