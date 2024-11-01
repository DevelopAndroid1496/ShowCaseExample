package com.example.showcaseviewexample

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.view.View

class ShowCaseView(context: Context): View(context) {

    private val paint = Paint().apply {
        color = resources.getColor(R.color.red)
    }


    private var targetRect: RectF? = null
    private var title: String? = null
    private var description: String? = null

    fun setTarget(view: View){
        targetRect = RectF(
            view.x,
            view.y,
            view.x + view.width,
            view.y + view.height
        ).apply {

        }

    }

    fun setTitle(title: String){
        this.title = title
    }

    fun setDescription(description: String){
        this.description = description
    }

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)

        canvas.drawRect(0f,0f,width.toFloat(),height.toFloat(),paint)

        targetRect?.let {
            paint.color = resources.getColor(R.color.transparent)
            canvas.drawRect(it, paint)

            // Dibujar el título y la descripción
            paint.color = resources.getColor(R.color.black) // Color negro
            paint.textSize = 20f
            canvas.drawText(title ?: "", it.left, it.top , paint)
            paint.textSize = 10f
            canvas.drawText(description ?: "", it.left, it.bottom + 30, paint)

        }
    }

}